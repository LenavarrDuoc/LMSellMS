package cl.duoc.lmsellms.exceptions;


import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    String title1 = "Error validación de datos."; //para HTTP 400
    String title2 = "Conflicto de datos."; //para HTTP 409
    String title3 = "Objeto no encontrado"; //para HTTP 404
    String title4 = "Servicio sin respuesta (Bad Gateway)."; //para HTTP 502
    String title5 = "Error en requisitos de datos."; //para HTTP 422

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerValidation(MethodArgumentNotValidException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(400);
        problemDetail.setTitle(title1);

        var errors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(error -> error.getField(), error -> error.getDefaultMessage(), (String existing, String replacement) -> existing));

    problemDetail.setProperty("Parámetro no válido", errors);
    return problemDetail;
    }

    @ExceptionHandler(IdExisteException.class)
    public ProblemDetail handlerExisteID(IdExisteException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(409); //HTTP 409 = conlficto de datos
        problemDetail.setTitle(title2);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(IdNoExisteException.class)
    public ProblemDetail handlerIdNoExiste(IdNoExisteException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(404); //HTTP 409 = conlficto de datos
        problemDetail.setTitle(title2);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(NombreDctoNoExisteException.class)
    public ProblemDetail handlerNombreDctoNoExisteID(NombreDctoNoExisteException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(404); //HTTP 404 = no encontrado
        problemDetail.setTitle(title3);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(NombreDctoExisteException.class)
    public ProblemDetail handlerNombreDctoExisteID(NombreDctoExisteException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(409); //HTTP 409 = conlficto de datos
        problemDetail.setTitle(title2);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(FecExpNoValidaException.class)
    public ProblemDetail handlerFecExpNoValida(FecExpNoValidaException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(422); //HTTP 422 = entidad inprocesable.
        problemDetail.setTitle(title5);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(FailedAPICallResponseExeption.class)
    public ProblemDetail handlerFailedAPICallResponse(FailedAPICallResponseExeption exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(502); //HTTP 502 = Bad Gateway
        problemDetail.setTitle(title4);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(VentaRealizadaException.class)
    public ProblemDetail handlerVentaRealizada(VentaRealizadaException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(409); //HTTP 409 = conlficto de datos
        problemDetail.setTitle(title2);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }


}
