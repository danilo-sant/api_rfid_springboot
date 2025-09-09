package com.desafio09.api_rfid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RfidController {

    @Autowired
    private LeituraRfidRepository leituraRfidRepository;

    @PostMapping("/leitura")
    public ResponseEntity<Map<String, String>> registrarLeitura(@RequestBody LeituraRfidRequest request) {
        try {
            // 1. Cria uma nova entidade para salvar no banco
            LeituraRfid novaLeitura = new LeituraRfid();

            // 2. Popula a entidade com os dados da requisição
            novaLeitura.setRfidTag(request.getRfid_tag());
            novaLeitura.setLeitorId(request.getLeitor_id());

            // 3. Salva a entidade no banco de dados usando o repositório
            leituraRfidRepository.save(novaLeitura);

            // 4. Retorna uma resposta de sucesso
            return ResponseEntity.ok(Map.of("status", "sucesso", "mensagem", "Leitura registrada com Spring Boot!"));

        } catch (Exception e) {
            // 5. Em caso de erro, retorna uma resposta de erro do servidor
            return ResponseEntity.status(500).body(Map.of("status", "erro", "mensagem", e.getMessage()));
        }
    }
}
