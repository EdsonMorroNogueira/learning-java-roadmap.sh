//package com.morro.edson.screenmatch_curso2.service;
//
//import com.theokanning.openai.completion.CompletionRequest;
//import com.theokanning.openai.service.OpenAiService;
//
//public class ConsultaChatGPT {
//    public static String obterTraducao(String texto) {
//        OpenAiService service = new OpenAiService("COLE A KEY AQUI");
//
//        CompletionRequest request = CompletionRequest.builder()
//                .model("gpt-3.5-turbo-instruct")
//                .prompt("traduz para o português o texto: " + texto)
//                .maxTokens(1000)
//                .temperature(0.7)
//                .build();
//
//        var response = service.createCompletion(request);
//        return response.getChoices().get(0).getText();
//
//    }
//}
