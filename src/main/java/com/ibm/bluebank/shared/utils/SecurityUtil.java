package com.ibm.bluebank.shared.utils;

import com.ibm.bluebank.cliente.dto.ClienteDto;
import com.ibm.bluebank.cliente.model.Cliente;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class SecurityUtil {

    public static String getHash(String senha) {
        return DigestUtils.md5DigestAsHex(senha.getBytes(StandardCharsets.UTF_8));
    }

    public static String gerarToken(Cliente cliente) {
        StringBuilder token = new StringBuilder();
        token.append(cliente.getCpf());
        token.append(cliente.getEmail());
        token.append(cliente.getConta().getAgencia());
        token.append(cliente.getConta().getNumero());
        return DigestUtils.md5DigestAsHex(token.toString().getBytes(StandardCharsets.UTF_8));
    }
}
