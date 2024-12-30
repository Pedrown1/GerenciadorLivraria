package com.ph.project.GerenciadorLivraria.dto;

import lombok.Builder;
import lombok.Data;

public class MessageResponseDTO {

    private String message;

    public MessageResponseDTO(String message) {
        this.message = message;
    }

    public MessageResponseDTO() {
    }

    public static class Builder {
        private String message;

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public MessageResponseDTO build() {
            MessageResponseDTO responseDTO = new MessageResponseDTO();
            responseDTO.setMessage(this.message);
            return responseDTO;
        }
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}