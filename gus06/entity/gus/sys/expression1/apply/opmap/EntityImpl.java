package gus06.entity.gus.sys.expression1.apply.opmap;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20151109";}

	private Service buildMap;
	private Map map0;


	public EntityImpl() throws Exception
	{
		buildMap = Outside.service(this,"gus.map.map1");
		map0 = new HashMap();
		
		put("_abs",		Outside.service(this,"gus.sys.expression1.apply.op._abs"));
		put("_acos",		Outside.service(this,"gus.sys.expression1.apply.op._acos"));
		put("_add",		Outside.service(this,"gus.sys.expression1.apply.op._add"));
		put("_as_e",		Outside.service(this,"gus.sys.expression1.apply.op._as_e"));
		put("_as_f",		Outside.service(this,"gus.sys.expression1.apply.op._as_f"));
		put("_as_g",		Outside.service(this,"gus.sys.expression1.apply.op._as_g"));
		put("_as_h",		Outside.service(this,"gus.sys.expression1.apply.op._as_h"));
		put("_as_p",		Outside.service(this,"gus.sys.expression1.apply.op._as_p"));
		put("_as_r",		Outside.service(this,"gus.sys.expression1.apply.op._as_r"));
		put("_as_s",		Outside.service(this,"gus.sys.expression1.apply.op._as_s"));
		put("_as_t",		Outside.service(this,"gus.sys.expression1.apply.op._as_t"));
		put("_as_v",		Outside.service(this,"gus.sys.expression1.apply.op._as_v"));
		put("_asin",		Outside.service(this,"gus.sys.expression1.apply.op._asin"));
		put("_atan",		Outside.service(this,"gus.sys.expression1.apply.op._atan"));
		put("_base64",		Outside.service(this,"gus.sys.expression1.apply.op._base64"));
		put("_binary",		Outside.service(this,"gus.sys.expression1.apply.op._binary"));
		put("_blank",		Outside.service(this,"gus.sys.expression1.apply.op._blank"));
		put("_cause",		Outside.service(this,"gus.sys.expression1.apply.op._cause"));
		put("_chance",		Outside.service(this,"gus.sys.expression1.apply.op._chance"));
		put("_charset",		Outside.service(this,"gus.sys.expression1.apply.op._charset"));
		put("_child",		Outside.service(this,"gus.sys.expression1.apply.op._child"));
		put("_children",	Outside.service(this,"gus.sys.expression1.apply.op._children"));
		put("_childrennames",	Outside.service(this,"gus.sys.expression1.apply.op._childrennames"));
		put("_childrennames0",	Outside.service(this,"gus.sys.expression1.apply.op._childrennames0"));
		put("_childrenpaths",	Outside.service(this,"gus.sys.expression1.apply.op._childrenpaths"));
		put("_class",		Outside.service(this,"gus.sys.expression1.apply.op._class"));
		put("_clipboard",	Outside.service(this,"gus.sys.expression1.apply.op._clipboard"));
		put("_clone",		Outside.service(this,"gus.sys.expression1.apply.op._clone"));
		put("_co",		Outside.service(this,"gus.sys.expression1.apply.op._co"));
		put("_co_i",		Outside.service(this,"gus.sys.expression1.apply.op._co_i"));
		put("_co_n",		Outside.service(this,"gus.sys.expression1.apply.op._co_n"));
		put("_collect",		Outside.service(this,"gus.sys.expression1.apply.op._collect"));
		put("_comparator",	Outside.service(this,"gus.sys.expression1.apply.op._comparator"));
		put("_cos",		Outside.service(this,"gus.sys.expression1.apply.op._cos"));
		put("_cosh",		Outside.service(this,"gus.sys.expression1.apply.op._cosh"));
		put("_count",		Outside.service(this,"gus.sys.expression1.apply.op._count"));
		put("_creationdate",	Outside.service(this,"gus.sys.expression1.apply.op._creationdate"));
		put("_d",		Outside.service(this,"gus.sys.expression1.apply.op._d"));
		put("_default",		Outside.service(this,"gus.sys.expression1.apply.op._default"));
		put("_desc",		Outside.service(this,"gus.sys.expression1.apply.op._desc"));
		put("_diff",		Outside.service(this,"gus.sys.expression1.apply.op._diff"));
		put("_dir1",		Outside.service(this,"gus.sys.expression1.apply.op._dir1"));
		put("_display",		Outside.service(this,"gus.sys.expression1.apply.op._display"));
		put("_div",		Outside.service(this,"gus.sys.expression1.apply.op._div"));
		put("_double",		Outside.service(this,"gus.sys.expression1.apply.op._double"));
		put("_e0",		Outside.service(this,"gus.sys.expression1.apply.op._e0"));
		put("_e_clipboard",	Outside.service(this,"gus.sys.expression1.apply.op._e_clipboard"));
		put("_e_close",		Outside.service(this,"gus.sys.expression1.apply.op._e_close"));
		put("_e_delete",	Outside.service(this,"gus.sys.expression1.apply.op._e_delete"));
		put("_e_each",		Outside.service(this,"gus.sys.expression1.apply.op._e_each"));
		put("_e_eachkey",	Outside.service(this,"gus.sys.expression1.apply.op._e_eachkey"));
		put("_e_empty",		Outside.service(this,"gus.sys.expression1.apply.op._e_empty"));
		put("_e_exec",		Outside.service(this,"gus.sys.expression1.apply.op._e_exec"));
		put("_e_initfile",	Outside.service(this,"gus.sys.expression1.apply.op._e_initfile"));
		put("_e_initdir",	Outside.service(this,"gus.sys.expression1.apply.op._e_initdir"));
		put("_e_keepall",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall"));
		put("_e_keepall_co",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_co"));
		put("_e_keepall_co_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_co_i"));
		put("_e_keepall_co_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_co_n"));
		put("_e_keepall_en",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_en"));
		put("_e_keepall_en_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_en_i"));
		put("_e_keepall_en_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_en_n"));
		put("_e_keepall_kco",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_kco"));
		put("_e_keepall_kco_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_kco_i"));
		put("_e_keepall_kco_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_kco_n"));
		put("_e_keepall_ken",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_ken"));
		put("_e_keepall_ken_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_ken_i"));
		put("_e_keepall_ken_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_ken_n"));
		put("_e_keepall_kst",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_kst"));
		put("_e_keepall_kst_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_kst_i"));
		put("_e_keepall_kst_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_kst_n"));
		put("_e_keepall_st",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_st"));
		put("_e_keepall_st_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_st_i"));
		put("_e_keepall_st_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_st_n"));
		put("_e_keepall_vco",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_vco"));
		put("_e_keepall_vco_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_vco_i"));
		put("_e_keepall_vco_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_vco_n"));
		put("_e_keepall_ven",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_ven"));
		put("_e_keepall_ven_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_ven_i"));
		put("_e_keepall_ven_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_ven_n"));
		put("_e_keepall_vst",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_vst"));
		put("_e_keepall_vst_i",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_vst_i"));
		put("_e_keepall_vst_n",	Outside.service(this,"gus.sys.expression1.apply.op._e_keepall_vst_n"));
		put("_e_open",		Outside.service(this,"gus.sys.expression1.apply.op._e_open"));
		put("_e_print",		Outside.service(this,"gus.sys.expression1.apply.op._e_print"));
		put("_e_println",	Outside.service(this,"gus.sys.expression1.apply.op._e_println"));
		put("_e_removeall",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall"));
		put("_e_removeall_co",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_co"));
		put("_e_removeall_co_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_co_i"));
		put("_e_removeall_co_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_co_n"));
		put("_e_removeall_en",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_en"));
		put("_e_removeall_en_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_en_i"));
		put("_e_removeall_en_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_en_n"));
		put("_e_removeall_kco",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_kco"));
		put("_e_removeall_kco_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_kco_i"));
		put("_e_removeall_kco_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_kco_n"));
		put("_e_removeall_ken",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_ken"));
		put("_e_removeall_ken_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_ken_i"));
		put("_e_removeall_ken_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_ken_n"));
		put("_e_removeall_kst",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_kst"));
		put("_e_removeall_kst_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_kst_i"));
		put("_e_removeall_kst_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_kst_n"));
		put("_e_removeall_st",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_st"));
		put("_e_removeall_st_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_st_i"));
		put("_e_removeall_st_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_st_n"));
		put("_e_removeall_vco",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_vco"));
		put("_e_removeall_vco_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_vco_i"));
		put("_e_removeall_vco_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_vco_n"));
		put("_e_removeall_ven",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_ven"));
		put("_e_removeall_ven_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_ven_i"));
		put("_e_removeall_ven_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_ven_n"));
		put("_e_removeall_vst",	Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_vst"));
		put("_e_removeall_vst_i",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_vst_i"));
		put("_e_removeall_vst_n",Outside.service(this,"gus.sys.expression1.apply.op._e_removeall_vst_n"));
		put("_e_reverse",	Outside.service(this,"gus.sys.expression1.apply.op._e_reverse"));
		put("_e_shuffle",	Outside.service(this,"gus.sys.expression1.apply.op._e_shuffle"));
		put("_e_sort",		Outside.service(this,"gus.sys.expression1.apply.op._e_sort"));
		put("_e_sort_inv",	Outside.service(this,"gus.sys.expression1.apply.op._e_sort_inv"));
		put("_empty",		Outside.service(this,"gus.sys.expression1.apply.op._empty"));
		put("_en",		Outside.service(this,"gus.sys.expression1.apply.op._en"));
		put("_en_i",		Outside.service(this,"gus.sys.expression1.apply.op._en_i"));
		put("_en_n",		Outside.service(this,"gus.sys.expression1.apply.op._en_n"));
		put("_eq",		Outside.service(this,"gus.sys.expression1.apply.op._eq"));
		put("_even",		Outside.service(this,"gus.sys.expression1.apply.op._even"));
		put("_every",		Outside.service(this,"gus.sys.expression1.apply.op._every"));
		put("_excludeall",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall"));
		put("_excludeall_co",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_co"));
		put("_excludeall_co_i",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_co_i"));
		put("_excludeall_co_n",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_co_n"));
		put("_excludeall_en",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_en"));
		put("_excludeall_en_i",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_en_i"));
		put("_excludeall_en_n",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_en_n"));
		put("_excludeall_kco",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_kco"));
		put("_excludeall_kco_i",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_kco_i"));
		put("_excludeall_kco_n",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_kco_n"));
		put("_excludeall_ken",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_ken"));
		put("_excludeall_ken_i",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_ken_i"));
		put("_excludeall_ken_n",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_ken_n"));
		put("_excludeall_kst",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_kst"));
		put("_excludeall_kst_i",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_kst_i"));
		put("_excludeall_kst_n",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_kst_n"));
		put("_excludeall_st",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_st"));
		put("_excludeall_st_i",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_st_i"));
		put("_excludeall_st_n",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_st_n"));
		put("_excludeall_vco",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_vco"));
		put("_excludeall_vco_i",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_vco_i"));
		put("_excludeall_vco_n",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_vco_n"));
		put("_excludeall_ven",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_ven"));
		put("_excludeall_ven_i",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_ven_i"));
		put("_excludeall_ven_n",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_ven_n"));
		put("_excludeall_vst",	Outside.service(this,"gus.sys.expression1.apply.op._excludeall_vst"));
		put("_excludeall_vst_i",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_vst_i"));
		put("_excludeall_vst_n",Outside.service(this,"gus.sys.expression1.apply.op._excludeall_vst_n"));
		put("_exec",		Outside.service(this,"gus.sys.expression1.apply.op._exec"));
		put("_executable",	Outside.service(this,"gus.sys.expression1.apply.op._executable"));
		put("_execute",		Outside.service(this,"gus.sys.expression1.apply.op._execute"));
		put("_exists",		Outside.service(this,"gus.sys.expression1.apply.op._exists"));
		put("_exp",		Outside.service(this,"gus.sys.expression1.apply.op._exp"));
		put("_ext",		Outside.service(this,"gus.sys.expression1.apply.op._ext"));
		put("_factorial",	Outside.service(this,"gus.sys.expression1.apply.op._factorial"));
		put("_features",	Outside.service(this,"gus.sys.expression1.apply.op._features"));
		put("_ff",		Outside.service(this,"gus.sys.expression1.apply.op._ff"));
		put("_file1",		Outside.service(this,"gus.sys.expression1.apply.op._file1"));
		put("_findall",		Outside.service(this,"gus.sys.expression1.apply.op._findall"));
		put("_findall_co",	Outside.service(this,"gus.sys.expression1.apply.op._findall_co"));
		put("_findall_co_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_co_i"));
		put("_findall_co_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_co_n"));
		put("_findall_en",	Outside.service(this,"gus.sys.expression1.apply.op._findall_en"));
		put("_findall_en_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_en_i"));
		put("_findall_en_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_en_n"));
		put("_findall_kco",	Outside.service(this,"gus.sys.expression1.apply.op._findall_kco"));
		put("_findall_kco_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_kco_i"));
		put("_findall_kco_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_kco_n"));
		put("_findall_ken",	Outside.service(this,"gus.sys.expression1.apply.op._findall_ken"));
		put("_findall_ken_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_ken_i"));
		put("_findall_ken_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_ken_n"));
		put("_findall_kst",	Outside.service(this,"gus.sys.expression1.apply.op._findall_kst"));
		put("_findall_kst_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_kst_i"));
		put("_findall_kst_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_kst_n"));
		put("_findall_st",	Outside.service(this,"gus.sys.expression1.apply.op._findall_st"));
		put("_findall_st_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_st_i"));
		put("_findall_st_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_st_n"));
		put("_findall_vco",	Outside.service(this,"gus.sys.expression1.apply.op._findall_vco"));
		put("_findall_vco_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_vco_i"));
		put("_findall_vco_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_vco_n"));
		put("_findall_ven",	Outside.service(this,"gus.sys.expression1.apply.op._findall_ven"));
		put("_findall_ven_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_ven_i"));
		put("_findall_ven_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_ven_n"));
		put("_findall_vst",	Outside.service(this,"gus.sys.expression1.apply.op._findall_vst"));
		put("_findall_vst_i",	Outside.service(this,"gus.sys.expression1.apply.op._findall_vst_i"));
		put("_findall_vst_n",	Outside.service(this,"gus.sys.expression1.apply.op._findall_vst_n"));
		put("_findfirst",	Outside.service(this,"gus.sys.expression1.apply.op._findfirst"));
		put("_findindexes",	Outside.service(this,"gus.sys.expression1.apply.op._findindexes"));
		put("_findlast",	Outside.service(this,"gus.sys.expression1.apply.op._findlast"));
		put("_findone",		Outside.service(this,"gus.sys.expression1.apply.op._findone"));
		put("_first",		Outside.service(this,"gus.sys.expression1.apply.op._first"));
		put("_flip_a",		Outside.service(this,"gus.sys.expression1.apply.op._flip_a"));
		put("_flip_d",		Outside.service(this,"gus.sys.expression1.apply.op._flip_d"));
		put("_flip_h",		Outside.service(this,"gus.sys.expression1.apply.op._flip_h"));
		put("_flip_v",		Outside.service(this,"gus.sys.expression1.apply.op._flip_v"));
		put("_freq",		Outside.service(this,"gus.sys.expression1.apply.op._freq"));
		put("_ft",		Outside.service(this,"gus.sys.expression1.apply.op._ft"));
		put("_future",		Outside.service(this,"gus.sys.expression1.apply.op._future"));
		put("_g",		Outside.service(this,"gus.sys.expression1.apply.op._g"));
		put("_g0",		Outside.service(this,"gus.sys.expression1.apply.op._g0"));
		put("_half",		Outside.service(this,"gus.sys.expression1.apply.op._half"));
		put("_hashcode",	Outside.service(this,"gus.sys.expression1.apply.op._hashcode"));
		put("_hasnext",		Outside.service(this,"gus.sys.expression1.apply.op._hasnext"));
		put("_height",		Outside.service(this,"gus.sys.expression1.apply.op._height"));
		put("_hexa",		Outside.service(this,"gus.sys.expression1.apply.op._hexa"));
		put("_image",		Outside.service(this,"gus.sys.expression1.apply.op._image"));
		put("_inf",		Outside.service(this,"gus.sys.expression1.apply.op._inf"));
		put("_inf0",		Outside.service(this,"gus.sys.expression1.apply.op._inf0"));
		put("_inv",		Outside.service(this,"gus.sys.expression1.apply.op._inv"));
		put("_is_array",	Outside.service(this,"gus.sys.expression1.apply.op._is_array"));
		put("_is_boolean",	Outside.service(this,"gus.sys.expression1.apply.op._is_boolean"));
		put("_is_char",		Outside.service(this,"gus.sys.expression1.apply.op._is_char"));
		put("_is_collection",	Outside.service(this,"gus.sys.expression1.apply.op._is_collection"));
		put("_is_date",		Outside.service(this,"gus.sys.expression1.apply.op._is_date"));
		put("_is_double",	Outside.service(this,"gus.sys.expression1.apply.op._is_double"));
		put("_is_e",		Outside.service(this,"gus.sys.expression1.apply.op._is_e"));
		put("_is_entity",	Outside.service(this,"gus.sys.expression1.apply.op._is_entity"));
		put("_is_exception",	Outside.service(this,"gus.sys.expression1.apply.op._is_exception"));
		put("_is_f",		Outside.service(this,"gus.sys.expression1.apply.op._is_f"));
		put("_is_false",	Outside.service(this,"gus.sys.expression1.apply.op._is_false"));
		put("_is_file",		Outside.service(this,"gus.sys.expression1.apply.op._is_file"));
		put("_is_float",	Outside.service(this,"gus.sys.expression1.apply.op._is_float"));
		put("_is_g",		Outside.service(this,"gus.sys.expression1.apply.op._is_g"));
		put("_is_h",		Outside.service(this,"gus.sys.expression1.apply.op._is_h"));
		put("_is_i",		Outside.service(this,"gus.sys.expression1.apply.op._is_i"));
		put("_is_int",		Outside.service(this,"gus.sys.expression1.apply.op._is_int"));
		put("_is_list",		Outside.service(this,"gus.sys.expression1.apply.op._is_list"));
		put("_is_long",		Outside.service(this,"gus.sys.expression1.apply.op._is_long"));
		put("_is_map",		Outside.service(this,"gus.sys.expression1.apply.op._is_map"));
		put("_is_null",		Outside.service(this,"gus.sys.expression1.apply.op._is_null"));
		put("_is_number",	Outside.service(this,"gus.sys.expression1.apply.op._is_number"));
		put("_is_obj",		Outside.service(this,"gus.sys.expression1.apply.op._is_obj"));
		put("_is_p",		Outside.service(this,"gus.sys.expression1.apply.op._is_p"));
		put("_is_r",		Outside.service(this,"gus.sys.expression1.apply.op._is_r"));
		put("_is_runnable",	Outside.service(this,"gus.sys.expression1.apply.op._is_runnable"));
		put("_is_s",		Outside.service(this,"gus.sys.expression1.apply.op._is_s"));
		put("_is_set",		Outside.service(this,"gus.sys.expression1.apply.op._is_set"));
		put("_is_string",	Outside.service(this,"gus.sys.expression1.apply.op._is_string"));
		put("_is_sysenv",	Outside.service(this,"gus.sys.expression1.apply.op._is_sysenv"));
		put("_is_sysprop",	Outside.service(this,"gus.sys.expression1.apply.op._is_sysprop"));
		put("_is_t",		Outside.service(this,"gus.sys.expression1.apply.op._is_t"));
		put("_is_true",		Outside.service(this,"gus.sys.expression1.apply.op._is_true"));
		put("_is_url",		Outside.service(this,"gus.sys.expression1.apply.op._is_url"));
		put("_is_v",		Outside.service(this,"gus.sys.expression1.apply.op._is_v"));
		put("_isdir",		Outside.service(this,"gus.sys.expression1.apply.op._isdir"));
		put("_isfile",		Outside.service(this,"gus.sys.expression1.apply.op._isfile"));
		put("_jdbc_dbset",	Outside.service(this,"gus.sys.expression1.apply.op._jdbc_dbset"));
		put("_jdbc_sqlquery",	Outside.service(this,"gus.sys.expression1.apply.op._jdbc_sqlquery"));
		put("_jdbc_tableset",	Outside.service(this,"gus.sys.expression1.apply.op._jdbc_tableset"));
		put("_join",		Outside.service(this,"gus.sys.expression1.apply.op._join"));
		put("_join_n",		Outside.service(this,"gus.sys.expression1.apply.op._join_n"));
		put("_keyset",		Outside.service(this,"gus.sys.expression1.apply.op._keyset"));
		put("_last",		Outside.service(this,"gus.sys.expression1.apply.op._last"));
		put("_log",		Outside.service(this,"gus.sys.expression1.apply.op._log"));
		put("_log10",		Outside.service(this,"gus.sys.expression1.apply.op._log10"));
		put("_lower",		Outside.service(this,"gus.sys.expression1.apply.op._lower"));
		put("_many",		Outside.service(this,"gus.sys.expression1.apply.op._many"));
		put("_map",		Outside.service(this,"gus.sys.expression1.apply.op._map"));
		put("_map0",		Outside.service(this,"gus.sys.expression1.apply.op._map0"));
		put("_max",		Outside.service(this,"gus.sys.expression1.apply.op._max"));
		put("_maxvalue",	Outside.service(this,"gus.sys.expression1.apply.op._maxvalue"));
		put("_md5",		Outside.service(this,"gus.sys.expression1.apply.op._md5"));
		put("_merge",		Outside.service(this,"gus.sys.expression1.apply.op._merge"));
		put("_message",		Outside.service(this,"gus.sys.expression1.apply.op._message"));
		put("_mime",		Outside.service(this,"gus.sys.expression1.apply.op._mime"));
		put("_mimehier",	Outside.service(this,"gus.sys.expression1.apply.op._mimehier"));
		put("_min",		Outside.service(this,"gus.sys.expression1.apply.op._min"));
		put("_minimize",	Outside.service(this,"gus.sys.expression1.apply.op._minimize"));
		put("_minvalue",	Outside.service(this,"gus.sys.expression1.apply.op._minvalue"));
		put("_mod",		Outside.service(this,"gus.sys.expression1.apply.op._mod"));
		put("_mult",		Outside.service(this,"gus.sys.expression1.apply.op._mult"));
		put("_n",		Outside.service(this,"gus.sys.expression1.apply.op._n"));
		put("_n2",		Outside.service(this,"gus.sys.expression1.apply.op._n2"));
		put("_n3",		Outside.service(this,"gus.sys.expression1.apply.op._n3"));
		put("_name",		Outside.service(this,"gus.sys.expression1.apply.op._name"));
		put("_name0",		Outside.service(this,"gus.sys.expression1.apply.op._name0"));
		put("_neg",		Outside.service(this,"gus.sys.expression1.apply.op._neg"));
		put("_nempty",		Outside.service(this,"gus.sys.expression1.apply.op._nempty"));
		put("_new",		Outside.service(this,"gus.sys.expression1.apply.op._new"));
		put("_next",		Outside.service(this,"gus.sys.expression1.apply.op._next"));
		put("_nextmap",		Outside.service(this,"gus.sys.expression1.apply.op._nextmap"));
		put("_none",		Outside.service(this,"gus.sys.expression1.apply.op._none"));
		put("_not",		Outside.service(this,"gus.sys.expression1.apply.op._not"));
		put("_notevery",	Outside.service(this,"gus.sys.expression1.apply.op._notevery"));
		put("_now",		Outside.service(this,"gus.sys.expression1.apply.op._now"));
		put("_nsum",		Outside.service(this,"gus.sys.expression1.apply.op._nsum"));
		put("_null",		Outside.service(this,"gus.sys.expression1.apply.op._null"));
		put("_octal",		Outside.service(this,"gus.sys.expression1.apply.op._octal"));
		put("_odd",		Outside.service(this,"gus.sys.expression1.apply.op._odd"));
		put("_one",		Outside.service(this,"gus.sys.expression1.apply.op._one"));
		put("_operator",	Outside.service(this,"gus.sys.expression1.apply.op._operator"));
		put("_opp",		Outside.service(this,"gus.sys.expression1.apply.op._opp"));
		put("_p0",		Outside.service(this,"gus.sys.expression1.apply.op._p0"));
		put("_palyndrome",	Outside.service(this,"gus.sys.expression1.apply.op._palyndrome"));
		put("_parent",		Outside.service(this,"gus.sys.expression1.apply.op._parent"));
		put("_parse_html",	Outside.service(this,"gus.sys.expression1.apply.op._parse_html"));
		put("_parse_json",	Outside.service(this,"gus.sys.expression1.apply.op._parse_json"));
		put("_past",		Outside.service(this,"gus.sys.expression1.apply.op._past"));
		put("_path",		Outside.service(this,"gus.sys.expression1.apply.op._path"));
		put("_pbe1strde",	Outside.service(this,"gus.sys.expression1.apply.op._pbe1strde"));
		put("_pbe1stren",	Outside.service(this,"gus.sys.expression1.apply.op._pbe1stren"));
		put("_pbe2strde",	Outside.service(this,"gus.sys.expression1.apply.op._pbe2strde"));
		put("_pbe2stren",	Outside.service(this,"gus.sys.expression1.apply.op._pbe2stren"));
		put("_pbe3strde",	Outside.service(this,"gus.sys.expression1.apply.op._pbe3strde"));
		put("_pbe3stren",	Outside.service(this,"gus.sys.expression1.apply.op._pbe3stren"));
		put("_pipe",		Outside.service(this,"gus.sys.expression1.apply.op._pipe"));
		put("_polynomial",	Outside.service(this,"gus.sys.expression1.apply.op._polynomial"));
		put("_pop",		Outside.service(this,"gus.sys.expression1.apply.op._pop"));
		put("_pos",		Outside.service(this,"gus.sys.expression1.apply.op._pos"));
		put("_previous",	Outside.service(this,"gus.sys.expression1.apply.op._previous"));
		put("_prime",		Outside.service(this,"gus.sys.expression1.apply.op._prime"));
		put("_properties",	Outside.service(this,"gus.sys.expression1.apply.op._properties"));
		put("_put",		Outside.service(this,"gus.sys.expression1.apply.op._put"));
		put("_random",		Outside.service(this,"gus.sys.expression1.apply.op._random"));
		put("_readable",	Outside.service(this,"gus.sys.expression1.apply.op._readable"));
		put("_rem",		Outside.service(this,"gus.sys.expression1.apply.op._rem"));
		put("_removeat",	Outside.service(this,"gus.sys.expression1.apply.op._removeat"));
		put("_replace",		Outside.service(this,"gus.sys.expression1.apply.op._replace"));
		put("_reverse",		Outside.service(this,"gus.sys.expression1.apply.op._reverse"));
		put("_rotate180",	Outside.service(this,"gus.sys.expression1.apply.op._rotate180"));
		put("_rotate270",	Outside.service(this,"gus.sys.expression1.apply.op._rotate270"));
		put("_rotate90",	Outside.service(this,"gus.sys.expression1.apply.op._rotate90"));
		put("_rs_col",		Outside.service(this,"gus.sys.expression1.apply.op._rs_col"));
		put("_rs_row",		Outside.service(this,"gus.sys.expression1.apply.op._rs_row"));
		put("_rs_rowstr",	Outside.service(this,"gus.sys.expression1.apply.op._rs_rowstr"));
		put("_searchall",	Outside.service(this,"gus.sys.expression1.apply.op._searchall"));
		put("_searchdirs",		Outside.service(this,"gus.sys.expression1.apply.op._searchdirs"));
		put("_searchdirs_filtername",	Outside.service(this,"gus.sys.expression1.apply.op._searchdirs_filtername"));
		put("_searchdirs_filterpath",	Outside.service(this,"gus.sys.expression1.apply.op._searchdirs_filterpath"));
		put("_searchfiles",		Outside.service(this,"gus.sys.expression1.apply.op._searchfiles"));
		put("_searchfiles_byext",	Outside.service(this,"gus.sys.expression1.apply.op._searchfiles_byext"));
		put("_searchfiles_byname",	Outside.service(this,"gus.sys.expression1.apply.op._searchfiles_byname"));
		put("_searchfiles_byname_i",	Outside.service(this,"gus.sys.expression1.apply.op._searchfiles_byname_i"));
		put("_searchfiles_filtername",	Outside.service(this,"gus.sys.expression1.apply.op._searchfiles_filtername"));
		put("_searchfiles_filterpath",	Outside.service(this,"gus.sys.expression1.apply.op._searchfiles_filterpath"));
		put("_searchfiles_filtersize",	Outside.service(this,"gus.sys.expression1.apply.op._searchfiles_filtersize"));
		put("_send_post",	Outside.service(this,"gus.sys.expression1.apply.op._send_post"));
		put("_sha1",		Outside.service(this,"gus.sys.expression1.apply.op._sha1"));
		put("_shift",		Outside.service(this,"gus.sys.expression1.apply.op._shift"));
		put("_shuffle",		Outside.service(this,"gus.sys.expression1.apply.op._shuffle"));
		put("_signum",		Outside.service(this,"gus.sys.expression1.apply.op._signum"));
		put("_sin",		Outside.service(this,"gus.sys.expression1.apply.op._sin"));
		put("_sinh",		Outside.service(this,"gus.sys.expression1.apply.op._sinh"));
		put("_size",		Outside.service(this,"gus.sys.expression1.apply.op._size"));
		put("_sort",		Outside.service(this,"gus.sys.expression1.apply.op._sort"));
		put("_sort_inv",	Outside.service(this,"gus.sys.expression1.apply.op._sort_inv"));
		put("_sortby",		Outside.service(this,"gus.sys.expression1.apply.op._sortby"));
		put("_sortby_inv",	Outside.service(this,"gus.sys.expression1.apply.op._sortby_inv"));
		put("_split",		Outside.service(this,"gus.sys.expression1.apply.op._split"));
		put("_splitlen",	Outside.service(this,"gus.sys.expression1.apply.op._splitlen"));
		put("_sqrt",		Outside.service(this,"gus.sys.expression1.apply.op._sqrt"));
		put("_square",		Outside.service(this,"gus.sys.expression1.apply.op._square"));
		put("_st",		Outside.service(this,"gus.sys.expression1.apply.op._st"));
		put("_st_i",		Outside.service(this,"gus.sys.expression1.apply.op._st_i"));
		put("_st_n",		Outside.service(this,"gus.sys.expression1.apply.op._st_n"));
		put("_stacktrace",	Outside.service(this,"gus.sys.expression1.apply.op._stacktrace"));
		put("_string",		Outside.service(this,"gus.sys.expression1.apply.op._string"));
		put("_sub",		Outside.service(this,"gus.sys.expression1.apply.op._sub"));
		put("_sub0",		Outside.service(this,"gus.sys.expression1.apply.op._sub0"));
		put("_sum",		Outside.service(this,"gus.sys.expression1.apply.op._sum"));
		put("_sup",		Outside.service(this,"gus.sys.expression1.apply.op._sup"));
		put("_sup0",		Outside.service(this,"gus.sys.expression1.apply.op._sup0"));
		put("_t0",		Outside.service(this,"gus.sys.expression1.apply.op._t0"));
		put("_t1",		Outside.service(this,"gus.sys.expression1.apply.op._t1"));
		put("_tan",		Outside.service(this,"gus.sys.expression1.apply.op._tan"));
		put("_tanh",		Outside.service(this,"gus.sys.expression1.apply.op._tanh"));
		put("_te_to_p",		Outside.service(this,"gus.sys.expression1.apply.op._te_to_p"));
		put("_text",		Outside.service(this,"gus.sys.expression1.apply.op._text"));
		put("_thismonth",	Outside.service(this,"gus.sys.expression1.apply.op._thismonth"));
		put("_thisyear",	Outside.service(this,"gus.sys.expression1.apply.op._thisyear"));
		put("_times",		Outside.service(this,"gus.sys.expression1.apply.op._times"));
		put("_titled",		Outside.service(this,"gus.sys.expression1.apply.op._titled"));
		put("_to_f",		Outside.service(this,"gus.sys.expression1.apply.op._to_f"));
		put("_to_h",		Outside.service(this,"gus.sys.expression1.apply.op._to_h"));
		put("_to_pbestrde",	Outside.service(this,"gus.sys.expression1.apply.op._to_pbestrde"));
		put("_to_pbestren",	Outside.service(this,"gus.sys.expression1.apply.op._to_pbestren"));
		put("_to_r",		Outside.service(this,"gus.sys.expression1.apply.op._to_r"));
		put("_to_sysenv",	Outside.service(this,"gus.sys.expression1.apply.op._to_sysenv"));
		put("_to_sysprop",	Outside.service(this,"gus.sys.expression1.apply.op._to_sysprop"));
		put("_to_t",		Outside.service(this,"gus.sys.expression1.apply.op._to_t"));
		put("_toboolean",	Outside.service(this,"gus.sys.expression1.apply.op._toboolean"));
		put("_tobyte",		Outside.service(this,"gus.sys.expression1.apply.op._tobyte"));
		put("_toclass",		Outside.service(this,"gus.sys.expression1.apply.op._toclass"));
		put("_tocx",		Outside.service(this,"gus.sys.expression1.apply.op._tocx"));
		put("_today",		Outside.service(this,"gus.sys.expression1.apply.op._today"));
		put("_todouble",	Outside.service(this,"gus.sys.expression1.apply.op._todouble"));
		put("_tofile",		Outside.service(this,"gus.sys.expression1.apply.op._tofile"));
		put("_tofilearray",	Outside.service(this,"gus.sys.expression1.apply.op._tofilearray"));
		put("_toint",		Outside.service(this,"gus.sys.expression1.apply.op._toint"));
		put("_toiterator",	Outside.service(this,"gus.sys.expression1.apply.op._toiterator"));
		put("_tolines",		Outside.service(this,"gus.sys.expression1.apply.op._tolines"));
		put("_tolist",		Outside.service(this,"gus.sys.expression1.apply.op._tolist"));
		put("_tomaparray",	Outside.service(this,"gus.sys.expression1.apply.op._tomaparray"));
		put("_tooperator",	Outside.service(this,"gus.sys.expression1.apply.op._tooperator"));
		put("_toprintstream",	Outside.service(this,"gus.sys.expression1.apply.op._toprintstream"));
		put("_tolong",		Outside.service(this,"gus.sys.expression1.apply.op._tolong"));
		put("_tosb",		Outside.service(this,"gus.sys.expression1.apply.op._tosb"));
		put("_toset",		Outside.service(this,"gus.sys.expression1.apply.op._toset"));
		put("_tostring",	Outside.service(this,"gus.sys.expression1.apply.op._tostring"));
		put("_tostringarray",	Outside.service(this,"gus.sys.expression1.apply.op._tostringarray"));
		put("_tourl",		Outside.service(this,"gus.sys.expression1.apply.op._tourl"));
		put("_trim",		Outside.service(this,"gus.sys.expression1.apply.op._trim"));
		put("_triple",		Outside.service(this,"gus.sys.expression1.apply.op._triple"));
		put("_type",		Outside.service(this,"gus.sys.expression1.apply.op._type"));
		put("_unique1",		Outside.service(this,"gus.sys.expression1.apply.op._unique1"));
		put("_unique2",		Outside.service(this,"gus.sys.expression1.apply.op._unique2"));
		put("_upper",		Outside.service(this,"gus.sys.expression1.apply.op._upper"));
		put("_utf8",		Outside.service(this,"gus.sys.expression1.apply.op._utf8"));
		put("_values",		Outside.service(this,"gus.sys.expression1.apply.op._values"));
		put("_valueset",	Outside.service(this,"gus.sys.expression1.apply.op._valueset"));
		put("_width",		Outside.service(this,"gus.sys.expression1.apply.op._width"));
		put("_wrap_g",		Outside.service(this,"gus.sys.expression1.apply.op._wrap_g"));
		put("_wrap_list",	Outside.service(this,"gus.sys.expression1.apply.op._wrap_list"));
		put("_wrap_set",	Outside.service(this,"gus.sys.expression1.apply.op._wrap_set"));
		put("_wrap_t",		Outside.service(this,"gus.sys.expression1.apply.op._wrap_t"));
		put("_writable",	Outside.service(this,"gus.sys.expression1.apply.op._writable"));
		put("_xor",		Outside.service(this,"gus.sys.expression1.apply.op._xor"));
		put("_yyyy",		Outside.service(this,"gus.sys.expression1.apply.op._yyyy"));
		put("_yyyymm",		Outside.service(this,"gus.sys.expression1.apply.op._yyyymm"));
		put("_yyyymmdd",	Outside.service(this,"gus.sys.expression1.apply.op._yyyymmdd"));
		put("_yyyymmdd_hhmm",	Outside.service(this,"gus.sys.expression1.apply.op._yyyymmdd_hhmm"));
		put("_yyyymmdd_hhmmss",	Outside.service(this,"gus.sys.expression1.apply.op._yyyymmdd_hhmmss"));
		put("_zero",		Outside.service(this,"gus.sys.expression1.apply.op._zero"));
	}
	
	private void put(String name, Service s)
	{map0.put(name,s);}
	
	
	
	
	public Object g() throws Exception
	{
		Map map = (Map) buildMap.t("operators");
		map.putAll(map0);
		return map;
	}
}