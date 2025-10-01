package edu.eci.arep.sad.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("Item con id " + id + " no encontrado");
    }
}
