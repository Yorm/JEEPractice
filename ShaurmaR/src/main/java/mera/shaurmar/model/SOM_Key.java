
package mera.shaurmar.model;

import java.io.Serializable;


public class SOM_Key implements Serializable{
    private long menuId;
    private long simpleordId;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.menuId ^ (this.menuId >>> 32));
        hash = 67 * hash + (int) (this.simpleordId ^ (this.simpleordId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SOM_Key other = (SOM_Key) obj;
        if (this.menuId != other.menuId) {
            return false;
        }
        if (this.simpleordId != other.simpleordId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SOM_Key{" + "menuId=" + menuId + ", simpleordId=" + simpleordId + '}';
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getSimpleordId() {
        return simpleordId;
    }

    public void setSimpleordId(long simpleordId) {
        this.simpleordId = simpleordId;
    }
    
    
    
}
