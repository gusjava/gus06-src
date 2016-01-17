package gus06.manager.gus.gyem;

public class GyemConst {

	public static final String KEY_MANAGERID		= "main.managerid";
	public static final String KEY_MANAGERBUILD		= "main.managerbuild";
	public static final String KEY_STARTTIME    		= "main.starttime";
	public static final String KEY_APPARGS         		= "main.appargs";
    
	public static final String ROOTPATH_RESOURCE		= "/gus06/resource/gus/gyem/";
	public static final String FILENAME_APPPROP		= "app.properties";
	public static final String FILENAME_APPMAPPING		= "appmapping.properties";
	public static final String DEFAULTBUILDER		= "entity";
    
	public static final String ENTITYCLASS_START		= "gus06.entity.";
	public static final String ENTITYCLASS_END		= ".EntityImpl";
    
	public static final String MODULECLASS_START		= "gus06.manager.gus.gyem.";
	public static final String MODULECLASS_END		= ".Module";
	
	public static final String TYPE_NOGUI			= "nogui";
	public static final String TYPE_SWING			= "swing";
	public static final String TYPE_JAVAFX			= "javafx";
	public static final String TYPE_DEFAULT			= "swing";
    	
	public static final String MAPNAME_MAIN			= "main";
	public static final String MAPNAME_PROP			= "prop";
	public static final String MAPNAME_MAPPING		= "mapping";
	public static final String MAPNAME_UNIQUE		= "unique";
	public static final String MAPNAME_ENTITYCLASS		= "entityclass";
	public static final String MAPNAME_ENTITYJAR		= "entityjar";
	public static final String MAPNAME_PATH			= "path";
    
	public static final String PROP_MAINGUI			= "app.maingui";
	public static final String PROP_TYPE			= "app.type";
	public static final String PROP_APPTITLE		= "app.title";
	public static final String PROP_APPSIZE			= "app.size";
	public static final String PROP_APPSTYLE		= "app.style";
	public static final String PROP_APPGUIDISABLED		= "app.guidisabled";
	public static final String PROP_APPLOADDISABLED		= "app.loaddisabled";
	public static final String PROP_APPCLURLS		= "app.clurls";
	public static final String PROP_SEQ_PROP		= "sequence.prop";
	public static final String PROP_SEQ_MAPPING		= "sequence.mapping";

	public static final String DEFAULT_APPTITLE		= "Default title";
	public static final String DEFAULT_APPSIZE		= "600 300";
    
	public static final String PATH_ROOTDIR			= "path.rootdir";
	public static final String PATH_APPPROPFILE		= "path.apppropfile";
	public static final String PATH_APPMAPPINGFILE		= "path.appmappingfile";
	public static final String PATH_GYEM_JARCACHE		= "path.gyem.jarcache";
	public static final String PATH_GYEM_JARDIR		= "path.gyem.jardir";
	public static final String PATH_GYEM_APIDIR		= "path.gyem.apidir";
	public static final String PATH_GYEM_POOLDIR		= "path.gyem.pooldir";
    
    
    
    
	public static final Class M001_E_CUSTOMIZER				= gus06.manager.gus.gyem.m001.e.customizer.Module.class;
	public static final Class M002_E_LAUNCHER				= gus06.manager.gus.gyem.m002.e.launcher.Module.class;
	public static final Class M003_E_START					= gus06.manager.gus.gyem.m003.e.start.Module.class;
	public static final Class M004_E_MAINFRAME				= gus06.manager.gus.gyem.m004.e.mainframe.Module.class;
	public static final Class M005_E_AFTER					= gus06.manager.gus.gyem.m005.e.after.Module.class;
	public static final Class M006_E_STARTED				= gus06.manager.gus.gyem.m006.e.started.Module.class;
	public static final Class M007_G_ARGS					= gus06.manager.gus.gyem.m007.g.args.Module.class;
	public static final Class M008_G_PARAMS					= gus06.manager.gus.gyem.m008.g.params.Module.class;
	public static final Class M009_T_INSIDE					= gus06.manager.gus.gyem.m009.t.inside.Module.class;
	public static final Class M010_G_INSIDE_ROOT				= gus06.manager.gus.gyem.m010.g.inside.root.Module.class;
	public static final Class M011_T_INSIDE_PROPLOADER			= gus06.manager.gus.gyem.m011.t.inside.proploader.Module.class;
	public static final Class M012_G_PROP					= gus06.manager.gus.gyem.m012.g.prop.Module.class;
	public static final Class M013_F_PROP_BOOL_DF				= gus06.manager.gus.gyem.m013.f.prop.bool.df.Module.class;
	public static final Class M014_F_PROP_BOOL_DT				= gus06.manager.gus.gyem.m014.f.prop.bool.dt.Module.class;
	public static final Class M015_G_PROP_INSIDE				= gus06.manager.gus.gyem.m015.g.prop.inside.Module.class;
	public static final Class M016_G_PROP_INSIDE_RESOURCEID			= gus06.manager.gus.gyem.m016.g.prop.inside.resourceid.Module.class;
	public static final Class M017_G_PROP_OUTSIDE				= gus06.manager.gus.gyem.m017.g.prop.outside.Module.class;  
	public static final Class M018_G_PROP_OUTSIDE_PARAMS			= gus06.manager.gus.gyem.m018.g.prop.outside.params.Module.class;
	public static final Class M019_G_PROP_OUTSIDE_FILE			= gus06.manager.gus.gyem.m019.g.prop.outside.file.Module.class;
	public static final Class M020_P_PROP_COMPLETE				= gus06.manager.gus.gyem.m020.p.prop.complete.Module.class;
	public static final Class M021_G_PATH_FIND_ROOTDIR			= gus06.manager.gus.gyem.m021.g.path.find.rootdir.Module.class;
	public static final Class M022_G_PATH_FIND_PROPFILE			= gus06.manager.gus.gyem.m022.g.path.find.propfile.Module.class;
	public static final Class M023_G_PATH_FIND_MAPPINGFILE			= gus06.manager.gus.gyem.m023.g.path.find.mappingfile.Module.class;
	public static final Class M024_T_ENTITY_PROVIDER			= gus06.manager.gus.gyem.m024.t.entity.provider.Module.class;
	public static final Class M025_F_ENTITY_FACTORY				= gus06.manager.gus.gyem.m025.t.entity.factory.Module.class;
	public static final Class M026_T_ENTITY_UNIQUE				= gus06.manager.gus.gyem.m026.t.entity.unique.Module.class;
	public static final Class M027_G_ENTITY_UNIQUEMAP			= gus06.manager.gus.gyem.m027.g.entity.uniquemap.Module.class;
	public static final Class M028_T_ENTITY_GENERATOR			= gus06.manager.gus.gyem.m028.t.entity.generator.Module.class;
	public static final Class M029_T_ENTITY_CLASSFINDER			= gus06.manager.gus.gyem.m029.t.entity.classfinder.Module.class;
	public static final Class M030_G_ENTITY_CLASSMAP			= gus06.manager.gus.gyem.m030.g.entity.classmap.Module.class;
	public static final Class M031_F_ENTITY_LOADER				= gus06.manager.gus.gyem.m031.f.entity.loader.Module.class;
	public static final Class M032_P_ENTITY_LOADER_SECURITY			= gus06.manager.gus.gyem.m032.p.entity.loader.security0.Module.class;
	public static final Class M033_P_ENTITY_LOADER_PARAM			= gus06.manager.gus.gyem.m033.p.entity.loader.param0.Module.class;
	public static final Class M034_T_ENTITY_CLASS1_LOAD			= gus06.manager.gus.gyem.m034.t.entity.class1.load.Module.class;
	public static final Class M035_T_ENTITY_CLASS1_LOAD_CL			= gus06.manager.gus.gyem.m035.t.entity.class1.load.cl.Module.class;
	public static final Class M036_T_ENTITY_CLASS1_LOAD_MAIN		= gus06.manager.gus.gyem.m036.t.entity.class1.load.main.Module.class;
	public static final Class M037_G_ENTITY_CLASS1_LOAD_MAIN_INITURLS	= gus06.manager.gus.gyem.m037.g.entity.class1.load.main.initurls.Module.class;
	public static final Class M038_G_ENTITY_CLASS1_LOAD_MAIN_NEWURLS	= gus06.manager.gus.gyem.m038.g.entity.class1.load.main.newurls.Module.class;
	public static final Class M039_T_ENTITY_CLASS1_LOAD_URL			= gus06.manager.gus.gyem.m039.t.entity.class1.load.url.Module.class;
	public static final Class M040_T_ENTITY_JARFILE				= gus06.manager.gus.gyem.m040.t.entity.jarfile.Module.class;
	public static final Class M041_G_ENTITY_JARFILE_MAP			= gus06.manager.gus.gyem.m041.g.entity.jarfile.map.Module.class;
	public static final Class M042_P_ENTITY_JARFILE_UPDATECACHE		= gus06.manager.gus.gyem.m042.p.entity.jarfile.updatecache.Module.class;
	public static final Class M043_T_ENTITY_NAMETOPATH			= gus06.manager.gus.gyem.m043.t.entity.nametopath.Module.class;
	public static final Class M044_T_ENTITY_FINDNAME			= gus06.manager.gus.gyem.m044.t.entity.findname.Module.class;
	public static final Class M045_G_MAPPING				= gus06.manager.gus.gyem.m045.g.mapping.Module.class;
	public static final Class M046_G_MAPPING_INSIDE				= gus06.manager.gus.gyem.m046.g.mapping.inside.Module.class;
	public static final Class M047_G_MAPPING_INSIDE_RESOURCEID		= gus06.manager.gus.gyem.m047.g.mapping.inside.resourceid.Module.class;
	public static final Class M048_G_MAPPING_OUTSIDE			= gus06.manager.gus.gyem.m048.g.mapping.outside.Module.class;
	public static final Class M049_G_MAPPING_OUTSIDE_PARAMS			= gus06.manager.gus.gyem.m049.g.mapping.outside.params.Module.class;
	public static final Class M050_G_MAPPING_OUTSIDE_FILE			= gus06.manager.gus.gyem.m050.g.mapping.outside.file.Module.class;
	public static final Class M051_P_MAPPING_COMPLETE			= gus06.manager.gus.gyem.m051.p.mapping.complete.Module.class;
	public static final Class M052_P_MANAGER_ERR				= gus06.manager.gus.gyem.m052.p.manager.err.Module.class;
	public static final Class M053_T_MANAGER_SERVICE			= gus06.manager.gus.gyem.m053.t.manager.service.Module.class;
	public static final Class M054_T_MANAGER_RESOURCE			= gus06.manager.gus.gyem.m054.t.manager.resource.Module.class;
	public static final Class M055_T_RULEFINDER				= gus06.manager.gus.gyem.m055.t.rulefinder.Module.class;
	public static final Class M056_T_RULEFINDER_FIND			= gus06.manager.gus.gyem.m056.t.rulefinder.find.Module.class;
	public static final Class M057_T_RULEFINDER_MAPPING			= gus06.manager.gus.gyem.m057.t.rulefinder.mapping.Module.class;
	public static final Class M058_G_RULEFINDER_MAPPING_MAPS		= gus06.manager.gus.gyem.m058.g.rulefinder.mapping.maps.Module.class;
	public static final Class M059_T_SERVICE_WRAPPER			= gus06.manager.gus.gyem.m059.t.service.wrapper.Module.class;
	public static final Class M060_G_SERVICE_WRAPPER_EMPTY			= gus06.manager.gus.gyem.m060.g.service.wrapper.empty.Module.class;
	public static final Class M061_T_SERVICE_WRAPPER1			= gus06.manager.gus.gyem.m061.t.service.wrapper1.Module.class;
	public static final Class M062_T_SERVICE_SRCTOSTRING			= gus06.manager.gus.gyem.m062.t.service.srctostring.Module.class;
	public static final Class M063_T_RESOURCE_PROVIDER			= gus06.manager.gus.gyem.m063.t.resource.provider.Module.class;
	public static final Class M064_T_RESOURCE_BUILDER			= gus06.manager.gus.gyem.m064.t.resource.builder.Module.class;
	public static final Class M065_T_RESOURCE_BUILDER_ANALYZE		= gus06.manager.gus.gyem.m065.t.resource.builder.analyze.Module.class;
	public static final Class M066_T_RESOURCE_BUILDER_FINDRB		= gus06.manager.gus.gyem.m066.t.resource.builder.findrb.Module.class;
	public static final Class M067_T_RB_STRING				= gus06.manager.gus.gyem.m067.t.rb.string.Module.class;
	public static final Class M068_T_RB_CLASS				= gus06.manager.gus.gyem.m068.t.rb.class1.Module.class;
	public static final Class M069_T_RB_NEW					= gus06.manager.gus.gyem.m069.t.rb.new1.Module.class;
	public static final Class M070_T_RB_FILE				= gus06.manager.gus.gyem.m070.t.rb.file.Module.class;
	public static final Class M071_T_RB_URL					= gus06.manager.gus.gyem.m071.t.rb.url.Module.class;
	public static final Class M072_T_RB_TOSTRING				= gus06.manager.gus.gyem.m072.t.rb.tostring.Module.class;
	public static final Class M073_T_RB_SYSPROP				= gus06.manager.gus.gyem.m073.t.rb.sysprop.Module.class;
	public static final Class M074_T_RB_SYSENV				= gus06.manager.gus.gyem.m074.t.rb.sysenv.Module.class;
	public static final Class M075_T_RB_PROPERTY				= gus06.manager.gus.gyem.m075.t.rb.property.Module.class;
	public static final Class M076_T_RB_PARAM				= gus06.manager.gus.gyem.m076.t.rb.param.Module.class;
	public static final Class M077_T_RB_CALL_G				= gus06.manager.gus.gyem.m077.t.rb.call.g.Module.class;
	public static final Class M078_T_RB_CALL_I				= gus06.manager.gus.gyem.m078.t.rb.call.i.Module.class;
	public static final Class M079_T_RB_CALL_T				= gus06.manager.gus.gyem.m079.t.rb.call.t.Module.class;
	public static final Class M080_T_RB_CALL_F				= gus06.manager.gus.gyem.m080.t.rb.call.f.Module.class;
	public static final Class M081_T_RB_CALL_R				= gus06.manager.gus.gyem.m081.t.rb.call.r.Module.class;
	public static final Class M082_T_RB_WRAP_G				= gus06.manager.gus.gyem.m082.t.rb.wrap.g.Module.class;
	public static final Class M083_T_RB_WRAP_I				= gus06.manager.gus.gyem.m083.t.rb.wrap.i.Module.class;
	public static final Class M084_T_RB_ENTITY				= gus06.manager.gus.gyem.m084.t.rb.entity.Module.class;
	public static final Class M085_T_RB_UNIQUEENTITY			= gus06.manager.gus.gyem.m085.t.rb.uniqueentity.Module.class;
	public static final Class M086_T_RB_NEWENTITY				= gus06.manager.gus.gyem.m086.t.rb.newentity.Module.class;
	public static final Class M087_T_RB_INSIDE				= gus06.manager.gus.gyem.m087.t.rb.inside.Module.class;
	public static final Class M088_T_RB_PATH				= gus06.manager.gus.gyem.m088.t.rb.path.Module.class;
	public static final Class M089_T_RB_POOL				= gus06.manager.gus.gyem.m089.t.rb.pool.Module.class;
	public static final Class M090_G_MAINFRAME_BUILDER			= gus06.manager.gus.gyem.m090.g.mainframe.builder.Module.class;
	public static final Class M091_P_MAINFRAME_HANDLER			= gus06.manager.gus.gyem.m091.p.mainframe.handler.Module.class;
	public static final Class M092_G_CUSTOMIZEFRAME				= gus06.manager.gus.gyem.m092.p.mainframe.customizer.Module.class;
	public static final Class M093_G_MAINGUI				= gus06.manager.gus.gyem.m093.g.maingui.Module.class;
	public static final Class M094_G_MAINGUI_BUILDER1			= gus06.manager.gus.gyem.m094.g.maingui.builder1.Module.class;
	public static final Class M095_G_MAINGUI_BUILDER2			= gus06.manager.gus.gyem.m095.g.maingui.builder2.Module.class;
	public static final Class M096_G_MAINGUI_DEFAULTGUI			= gus06.manager.gus.gyem.m096.g.maingui.defaultgui.Module.class;
	public static final Class M097_E_EXIT_ASK				= gus06.manager.gus.gyem.m097.e.exit.ask.Module.class;
	public static final Class M098_F_EXIT_ASK				= gus06.manager.gus.gyem.m098.f.exit.ask0.Module.class;
	public static final Class M099_G_ERR_LIST				= gus06.manager.gus.gyem.m099.g.err.list.Module.class;
	public static final Class M100_G_PATH					= gus06.manager.gus.gyem.m100.g.path.Module.class;
	public static final Class M101_G_PATH_PREDEFINED			= gus06.manager.gus.gyem.m101.g.path.predefined.Module.class;
	public static final Class M102_R_FILEPROVIDER				= gus06.manager.gus.gyem.m102.r.fileprovider.Module.class;
	public static final Class M103_T_GENERATOR				= gus06.manager.gus.gyem.m103.t.generator.Module.class;
	public static final Class M104_T_BUILD_MAP				= gus06.manager.gus.gyem.m104.t.build.map.Module.class;
	public static final Class M105_T_BUILD_LIST				= gus06.manager.gus.gyem.m105.t.build.list.Module.class;
	public static final Class M106_G_CONSTMAP				= gus06.manager.gus.gyem.m106.g.constmap.Module.class;
	public static final Class M107_G_MODULECLASSMAP				= gus06.manager.gus.gyem.m107.g.moduleclassmap.Module.class;
	public static final Class M108_R_SYSTEM_FIND				= gus06.manager.gus.gyem.m108.r.system.find.Module.class;
	public static final Class M109_P_IMPORTENTITY				= gus06.manager.gus.gyem.m109.p.importentity.Module.class;
	public static final Class M110_F_ENTITY_ISMULTIPLE			= gus06.manager.gus.gyem.m110.f.entity.ismultiple.Module.class;
	public static final Class M111_T_RB_FACTORY				= gus06.manager.gus.gyem.m111.t.rb.factory.Module.class;
	public static final Class M112_E_TYPE_NOGUI				= gus06.manager.gus.gyem.m112.e.type.nogui.Module.class;
	public static final Class M113_E_TYPE_SWING				= gus06.manager.gus.gyem.m113.e.type.swing.Module.class;
	public static final Class M114_E_TYPE_JAVAFX				= gus06.manager.gus.gyem.m114.e.type.javafx.Module.class;
	public static final Class M115_P_JAVAFX_STAGE_HANDLER			= gus06.manager.gus.gyem.m115.p.javafx.stage.handler.Module.class;
	public static final Class M116_P_JAVAFX_STAGE_CUSTOMIZER		= gus06.manager.gus.gyem.m116.p.javafx.stage.customizer.Module.class;
	public static final Class M117_G_JAVAFX_SCENE_BUILDER			= gus06.manager.gus.gyem.m117.g.javafx.scene.builder.Module.class;
	public static final Class M118_G_JAVAFX_SCENE_BUILDER1			= gus06.manager.gus.gyem.m118.g.javafx.scene.builder1.Module.class;
	public static final Class M119_G_JAVAFX_SCENE_BUILDER2			= gus06.manager.gus.gyem.m119.g.javafx.scene.builder2.Module.class;
	public static final Class M120_G_JAVAFX_SCENE_DEFAULTGUI		= gus06.manager.gus.gyem.m120.g.javafx.scene.defaultgui.Module.class;
	public static final Class M121_G_DEFAULTGUI_EMPTYTEXT			= gus06.manager.gus.gyem.m121.g.defaultgui.emptytext.Module.class;
	
    
    
}