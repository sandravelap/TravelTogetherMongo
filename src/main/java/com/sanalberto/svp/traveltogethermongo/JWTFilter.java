package com.sanalberto.svp.traveltogethermongo;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;

import java.security.Principal;

@Provider
@JwtTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {

        // 🔑 IMPORTANTE PARA CORS
        if ("OPTIONS".equalsIgnoreCase(requestContext.getMethod())) {
            return;
        }
        // Buscamos si hay un token y retornamos si no existe
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // MODO DESARROLLO: Si quieres saltarte el token en local, configurar en el recurso Authorization:dev-mode
        if ("dev-mode".equals(authHeader)) {
            // Inyectamos un SecurityContext "fake" con un alias de prueba
            setDummySecurityContext(requestContext, "carlos_picos");
            return;
        }
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            abort(requestContext, "Token no proporcionado");
            return;
        }
        // Si existe el token
        String token = authHeader.substring("Bearer ".length());

        try {
            // Intentamos decodificar el token para comprobar que es correcto y no ha expirado
            DecodedJWT jwt = JWT.require(
                Algorithm.HMAC256("tu_clave_secreta_super_segura")
            ).build().verify(token);

            // Sacamos el alias del token
            String alias = jwt.getSubject();

            // Creamos un security context con los datos extraidos del token
            SecurityContext originalContext = requestContext.getSecurityContext();

            SecurityContext newContext = new SecurityContext() {
                // Aquí sobreescribimos la función para que devuelva el alias al invocarla
                @Override
                public Principal getUserPrincipal() {
                    return () -> alias;
                }

                @Override
                public boolean isUserInRole(String role) {
                    return false;
                }

                @Override
                public boolean isSecure() {
                    return originalContext.isSecure();
                }

                @Override
                public String getAuthenticationScheme() {
                    return "Bearer";
                }
            };

            requestContext.setSecurityContext(newContext);

        } catch (JWTVerificationException e) {
            abort(requestContext, "Token expirado o inválido");
        }
    }
    // Función que aborta la carga del token y envía un mensaje en función del error
    private void abort(ContainerRequestContext ctx, String message) {
        ctx.abortWith(
            Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"error\":\"" + message + "\"}")
                .type("application/json")
                .build()
        );
    }
    // Contexto del token para pruebas
    private void setDummySecurityContext(ContainerRequestContext context, String userId) {
        // Obtenemos el contexto original por si necesitamos saber si es HTTPS, etc.
        final SecurityContext currentSecurityContext = context.getSecurityContext();

        context.setSecurityContext(new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
                // Aquí es donde "inyectamos" el ID que usará tu servicio REST
                return () -> userId;
            }

            @Override
            public boolean isUserInRole(String role) {
                // En modo dev, podrías decir que el usuario tiene todos los roles
                return true;
            }

            @Override
            public boolean isSecure() {
                return currentSecurityContext.isSecure();
            }

            @Override
            public String getAuthenticationScheme() {
                return "DEBUG-MODE";
            }
        });
    }
}