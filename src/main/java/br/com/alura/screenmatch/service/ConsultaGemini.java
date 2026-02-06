package br.com.alura.screenmatch.service;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaGemini {
    private static Dotenv dotenv = Dotenv.load();
    private static String apiKey = dotenv.get("API_KEY_GOOGLE_AI_STUDIO");

    public static String obterTraducao(String texto) {
        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();

        String prompt = "Traduza para o português o seguinte texto: " + texto;

        return model.chat(prompt).trim();
    }
}