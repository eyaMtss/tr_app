package com.tunidesign.backendutilisateurmicroservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private String message;
    private String stackTrace;

}
