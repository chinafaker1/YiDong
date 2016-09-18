/*
 * Date: 2013-7-24
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm;

import java.io.IOException;

import cn.com.taiji.tongji.model.protocol.sample.SampleTopic;

/**
 * 
 * @author Peream <br>
 *         Create Time：2013-7-24 下午4:20:36<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public interface SampleTopicManager
{
	public void sendTopic(SampleTopic sampleTopic) throws IOException;
}
