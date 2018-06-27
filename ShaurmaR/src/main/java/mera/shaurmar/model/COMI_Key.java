
package mera.shaurmar.model;

import java.io.Serializable;


public class COMI_Key  implements Serializable{
    private static final long serialVersionUID = 14L;
    
    private long comtable_id;
    private long ingredientId;

    public long getComtable_id() {
        return comtable_id;
    }

    public void setComtable_id(long comtable_id) {
        this.comtable_id = comtable_id;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.comtable_id ^ (this.comtable_id >>> 32));
        hash = 53 * hash + (int) (this.ingredientId ^ (this.ingredientId >>> 32));
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
        final COMI_Key other = (COMI_Key) obj;
        if (this.comtable_id != other.comtable_id) {
            return false;
        }
        if (this.ingredientId != other.ingredientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "COMI_Key{" + "comtable_id=" + comtable_id + ", ingredientId=" + ingredientId + '}';
    }

    
    
}
