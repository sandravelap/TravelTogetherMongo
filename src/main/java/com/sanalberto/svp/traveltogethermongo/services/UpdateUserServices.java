package com.sanalberto.svp.traveltogethermongo.services;


import com.sanalberto.svp.traveltogethermongo.dto.UpdateUserDTO;
import com.sanalberto.svp.traveltogethermongo.repositories.UpdateUserRepo;

public class UpdateUserServices {
    private UpdateUserRepo updateUserRepo = new UpdateUserRepo();

    public String update(UpdateUserDTO updateUserDTO) {

        String respuesta = "";
        // Devolvemos un mensaje distinto dependiendo de si se ha podido actualizar el usuario.
        if (updateUserRepo.update(updateUserDTO)) {
            respuesta = "El usuario se ha actualizado correctamente";
        } else {
            respuesta = "No se ha podido actualizar el usuario";
        }
        
        return respuesta;
    }
}