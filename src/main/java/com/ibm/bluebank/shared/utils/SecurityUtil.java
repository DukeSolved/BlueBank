package com.ibm.bluebank.shared.utils;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class SecurityUtil {

    public static String getHash(String senha) {
        return DigestUtils.md5DigestAsHex(senha.getBytes(StandardCharsets.UTF_8));
    }

    public static String gerarToken(ClienteDto clienteDto) {
        StringBuilder token = new StringBuilder();
        token.append(clienteDto.getCpf());
        token.append(clienteDto.getEmail());
        if (clienteDto.getConta().isPresent()) {
            token.append(clienteDto.getConta().get().getAgencia());
            token.append(clienteDto.getConta().get().getNumero());
        }
        return DigestUtils.md5DigestAsHex(token.toString().getBytes(StandardCharsets.UTF_8));
    }
}
