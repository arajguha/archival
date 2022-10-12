package app.hook.archival.commons;

import app.hook.archival.commons.exception.GenericException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiResponse<T> {
    private Boolean status;
    private List<String> errors;
    private T result;

    public ApiResponse() {}

    public ApiResponse(Boolean status, List<String> errors, T result) {
        this.status = status;
        this.errors = errors;
        this.result = result;
    }

    public ApiResponse(T result) {
        this.status = true;
        this.result = result;
    }

    public ApiResponse(GenericException ge) {
        this.status = false;
        this.errors = new ArrayList<>(Arrays.asList(ge.getMessage()));
        this.result = null;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
