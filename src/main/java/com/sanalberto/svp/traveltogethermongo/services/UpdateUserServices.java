package com.sanalberto.svp.traveltogethermongo.services;


import com.sanalberto.svp.traveltogethermongo.dto.UpdateUserDTO;
import com.sanalberto.svp.traveltogethermongo.repositories.UpdateUserRepo;

import java.util.Arrays;
import java.util.List;

public class UpdateUserServices {
    private UpdateUserRepo updateUserRepo = new UpdateUserRepo();

    public String update(UpdateUserDTO updateUserDTO) {

        String respuesta = "";
        // Añadimos las opciones válidas de tabaco y mascota
        List<String> tabacoOptions = Arrays.asList("fumador", "tolerante", "intolerante");
        List<String> mascotaOptions = Arrays.asList("compañía", "asistencia", "tolerante", "intolerante");
        // Comprobamos que las opciones de tabaco y mascota son correctas
        // antes de llamar al repositorio.
        if (tabacoOptions.contains(updateUserDTO.getTabaco()) || updateUserDTO.getTabaco() == null) {
            if (mascotaOptions.contains(updateUserDTO.getMascota()) || updateUserDTO.getMascota() == null) {
                // Devolvemos un mensaje distinto dependiendo de si se ha podido actualizar el usuario.
                if (updateUserRepo.update(updateUserDTO)) {
                    respuesta = "El usuario se ha actualizado correctamente";
                } else {
                    respuesta = "No se ha podido actualizar el usuario";
                }
            } else {
                respuesta = "El campo mascota no es válido";
            }
        } else {
            respuesta = "El campo tabaco no es válido";
        }
        
        return respuesta;
    }
}