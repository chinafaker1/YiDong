/*
 * Date: 2013-7-26
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.mycomm.manager.comm.AbstractTopicManager;
import cn.com.taiji.tongji.model.protocol.sample.SampleTopic;

/**
 * 当前系统（SAMPLE）用于发送topic的manager
 * 
 * @author Peream <br>
 *         Create Time：2013-7-26 上午11:56:57<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Service
public class SampleTopicManagerImpl extends AbstractTopicManager implements SampleTopicManager
{
	@Autowired
	public SampleTopicManagerImpl(CommParamConfig config)
	{
		super(config.getBusUrl(), config.getServiceName());
	}

	@Override
	public void sendTopic(SampleTopic sampleTopic) throws IOException
	{
		super.topicHttpPost(sampleTopic);
	}

}
