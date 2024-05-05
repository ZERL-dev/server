package ZERL.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpServletRequest;

import ZERL.server.models.ErrorInfo;

@Controller
public class CustomError {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody ErrorInfo
    unauthorized(HttpServletRequest req, Exception error) {
        return new ErrorInfo(req, "User Error: ", error);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody ErrorInfo
    notFound(HttpServletRequest req, Exception error) {
        return new ErrorInfo(req, "User Error: ", error);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody ErrorInfo
    serverError(HttpServletRequest req, Exception error) {
        return new ErrorInfo(req, "Server Error: ", error);
    }
}
