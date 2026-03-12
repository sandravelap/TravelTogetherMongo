package com.sanalberto.svp.traveltogethermongo.services;


import com.sanalberto.svp.traveltogethermongo.dto.UpdateUserDTO;
import com.sanalberto.svp.traveltogethermongo.repositories.UpdateUserRepo;

public class UpdateUserServices {
    private UpdateUserRepo updateUserRepo = new UpdateUserRepo();

    public String update(UpdateUserDTO updateUserDTO, String alias) {

        String respuesta = "";
        respuesta = updateUserRepo.update(updateUserDTO, alias);
        return respuesta;
    }
}