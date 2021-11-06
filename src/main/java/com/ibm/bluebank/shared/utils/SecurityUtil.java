package com.ibm.bluebank.shared.utils;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class SecurityUtil {

    public static String getHash(String senha) {
        return Arrays.toString(DigestUtils.sha1(senha));
    }

    public static String getToken(ClienteDto clienteDto) {
        StringBuilder token = new StringBuilder();
        token.append(clienteDto.getCpf());
        token.append(clienteDto.getEmail());
        if (clienteDto.getConta().isPresent()) {
            token.append(clienteDto.getConta().get().getAgencia());
            token.append(clienteDto.getConta().get().getNumero());
        }
        return Arrays.toString(DigestUtils.sha1(token.toString()));
    }
}
