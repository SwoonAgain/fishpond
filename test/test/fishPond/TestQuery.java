package test.fishPond;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fishpond.app.DeviceEditParameterHelper;
import fishpond.app.CommandMappingHelper.CommandType;
import fishpond.dao.DeviceEditParameterDao;
import fishpond.dao.impl.CommandDaoImpl;
import fishpond.dao.impl.DeviceDaoImpl;
import fishpond.entity.Command;
import fishpond.entity.Device;
import fishpond.entity.DeviceEditParameter;
import fishpond.utils.ConvertUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml"})
public class TestQuery {

//	@Resource(name = "deviceEditParameterDaoImpl")
//	private DeviceEditParameterDao deviceEditParameterDao;
//	
//	@Test
//	public void findById() {
//		DeviceEditParameter dep = deviceEditParameterDao.findByDeviceId(1);
//		System.out.println(dep);
//	}
	
	@Resource(name = "deviceDaoImpl")
	private DeviceDaoImpl deviceDaoImpl;
	
	@Resource(name = "commandDaoImpl")
	private CommandDaoImpl commandDaoImpl;
	
	@Test
	public void findByIdDDD() {
//		Device dep = deviceDaoImpl.findByDtuCode("010101");
//		System.out.println(dep);
		
//		Command command = commandDaoImpl.findByName("heartbeat&register");
//		System.out.println(command);
//		System.out.println(command.getRdSend()==null);
	}
	
//	@Test
//	public void testCommandCompose(){
//		byte[] b= DeviceEditParameterHelper.compose("secondMealQuantity", CommandType.MODIFY_SEND,"3452345245");
//		String str = ConvertUtil.bytesToHexString(b);
//		System.out.println("str   "+str);
//	}
}
