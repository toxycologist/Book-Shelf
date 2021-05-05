package pl.kiepura.Book.Shelf.security;


import lombok.Getter;

@Getter
public enum ApplicationUserPermission {
    BOOK_READ("book:read"),
    BOOK_MODIFY("book:write"),
    ;


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }


}
