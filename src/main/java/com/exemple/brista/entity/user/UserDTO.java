package com.exemple.brista.entity.user;

import java.util.List;

import com.exemple.brista.entity.Comentario;
import com.exemple.brista.entity.Roteiro;

public record UserDTO(String login, String username, List<Comentario> comentarios, String photo,  Roteiro roteiro) { }
