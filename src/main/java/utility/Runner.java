package utility;

import daos.TextManager;
import models.OrigText;

import java.util.List;

public class Runner {
    private TextManager tm=new TextManager();

    protected OrigText findById(int id){
        return tm.findById(id);
    }

    protected List<OrigText> findAll(){
        return tm.findAll();
    }

    protected Boolean update(OrigText dto){
        return tm.update(dto);
    }

    protected Boolean create(OrigText dto){
        return tm.create(dto);
    }
    protected Boolean delete(int id){
        return tm.delete(id);
    }
}
