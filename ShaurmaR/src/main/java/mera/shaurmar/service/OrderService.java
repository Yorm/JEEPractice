package mera.shaurmar.service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.CompoundOrd;
import mera.shaurmar.dto.CompoundOrdDTO;
import mera.shaurmar.model.Menu;
import mera.shaurmar.model.SimpleOrd;
import mera.shaurmar.dto.SimpleOrdDTO;
import mera.shaurmar.model.Status;

@Named
@ApplicationScoped
public class OrderService extends Service{
     
    public OrderService() {
        log = Logger.getLogger(OrderService.class.getName());
        db = new DBService();
    }

    public SimpleOrd getSimpleOrd(long id) {
        log.log(Level.INFO,"Get simple order "+id);
        return (SimpleOrd)db.findObj(new SimpleOrd(),id);
    }

    public CompoundOrd getCompuondOrd(long id) {
        log.log(Level.INFO,"Get compound order "+id);
        return (CompoundOrd)db.findObj(new CompoundOrd(), id);
    }

    public SimpleOrd saveSimpleOrd(SimpleOrdDTO ordDto) {
        //TODO into dbservice?
        SimpleOrd ord = new SimpleOrd();
        ord.setBuyer(ordDto.buyer);
        ord.setCreationDate(new Date());
        ord.setNote(ordDto.note);
        //TODO ord.setPrice();
        ord.setStatus(Status.NEW);
        //TODO ord.setMenuSh();
        
        log.log(Level.INFO,"Save simple order "+ord);
        return (SimpleOrd)db.saveObj(ord);
    }

    public CompoundOrd saveCompoundOrd(CompoundOrdDTO ordDto) {
        //TODO into dbservice?
        SimpleOrd ord = new SimpleOrd();
        ord.setBuyer(ordDto.buyer);
        ord.setCreationDate(new Date());
        ord.setNote(ordDto.note);
        //TODO ord.setPrice();
        ord.setStatus(Status.NEW);
        //TODO ord.setIngredients();
        
        log.log(Level.INFO,"Save compound order "+ord);
        return (CompoundOrd)db.saveObj(ord);
    }

    public SimpleOrd upSimpleOrd(SimpleOrd ord) {
        log.log(Level.INFO,"Update simple order "+ord);
        return (SimpleOrd)db.updateObj(ord, ord.getId());
    }

    public CompoundOrd upCompoundOrd(CompoundOrd ord) {
        log.log(Level.INFO,"Update compound order "+ord);
        return (CompoundOrd)db.updateObj(ord, ord.getId());
    }

    public boolean delSimpleOrd(long id) {
        log.log(Level.INFO,"Delete simple order "+id);
        return db.deleteObj(new SimpleOrd(),id);
    }

    public boolean delCompoundOrd(long id) {
        log.log(Level.INFO,"Delete compound order "+id);
        return db.deleteObj(new CompoundOrd(),id);
    }
}
