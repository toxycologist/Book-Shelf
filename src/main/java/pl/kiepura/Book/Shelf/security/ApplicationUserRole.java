package pl.kiepura.Book.Shelf.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static pl.kiepura.Book.Shelf.security.ApplicationUserPermission.BOOK_MODIFY;
import static pl.kiepura.Book.Shelf.security.ApplicationUserPermission.BOOK_READ;

@Getter
public enum ApplicationUserRole {
    OWNER(Sets.newHashSet(BOOK_MODIFY)),
    GUEST(Sets.newHashSet(BOOK_READ));

    private final Set<ApplicationUserPermission> permissions;


    ApplicationUserRole(Set<ApplicationUserPermission> getPermissions) {
        this.permissions = getPermissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
