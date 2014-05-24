package com.zplan.consloe.fmtest;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Fmtest model.
 */
@SuppressWarnings("serial")
public class Fmtest extends Model<Fmtest> {
	public static final Fmtest dao = new Fmtest();
	
	public static Page<Fmtest> getQuery(int page){
		return dao.paginate(page, 10, "select *", "from fmtest order by id asc");		
	}
}