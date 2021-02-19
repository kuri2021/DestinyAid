package com.example.destinyaid;

import android.widget.TextView;

public class Collection_wonder_Item {
    public String Equipitemname_tv;
    public String kategorie;
    public int Equipitem_iv,Equipitemlock_iv,ability1,ability2,ability3,ability4;

    public Collection_wonder_Item(String equipitemname_tv, String kategorie, int equipitem_iv, int equipitemlock_iv, int ability1, int ability2, int ability3, int ability4) {
        Equipitemname_tv = equipitemname_tv;
        this.kategorie = kategorie;
        Equipitem_iv = equipitem_iv;
        Equipitemlock_iv = equipitemlock_iv;
        this.ability1 = ability1;
        this.ability2 = ability2;
        this.ability3 = ability3;
        this.ability4 = ability4;
    }

    public Collection_wonder_Item() {
    }
}
