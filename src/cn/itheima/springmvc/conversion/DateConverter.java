package cn.itheima.springmvc.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * S : 页面传递的类型
 * T : 转换后的类型
 * @author 周双
 *
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			if(source!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.parse(source);
			}
		}catch(Exception e){
			
		}
		return null;
	}

}
