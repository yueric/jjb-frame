package com.zplan.consloe.graffitiinfo;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Graffitiinfo model.
 */
@SuppressWarnings("serial")
public class Graffitiinfo extends Model<Graffitiinfo> {
	public static final Graffitiinfo dao = new Graffitiinfo();
	
	public static Page<Graffitiinfo> getQuery(int page){
		return dao.paginate(page, 10, "select *", "from graffitiinfo order by id asc");		
	}
}