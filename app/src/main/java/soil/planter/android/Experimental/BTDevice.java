package soil.planter.android.Experimental;

import android.os.ParcelUuid;

public class BTDevice{
    private String name;
    private String adress;
    private String alias;
    private ParcelUuid[] uuids;

    public BTDevice(String name, String adress, String alias, ParcelUuid[] uuids) {
        this.name = name;
        this.adress = adress;
        this.alias = alias;
        this.uuids = uuids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public ParcelUuid[] getUuids() {
        return uuids;
    }

    public void setUuids(ParcelUuid[] uuids) {
        this.uuids = uuids;
    }
}