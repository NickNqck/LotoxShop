package fr.nicknqck.utils;

import lombok.Getter;

@Getter
public enum Ranks {

    Client("§7SDF"),
    Confirmer("§7Client"),
    VIP("§6VIP");

    private final String name;
    Ranks(String name) {
        this.name = name;
    }
    public static Ranks getFromString(String string) {
        for (Ranks r : Ranks.values()) {
            if (r.getName().equals(string)) {
                return r;
            }
        }
        return Client;
    }
}
