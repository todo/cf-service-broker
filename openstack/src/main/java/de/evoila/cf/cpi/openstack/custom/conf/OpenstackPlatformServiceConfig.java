/**
 * 
 */
package de.evoila.cf.cpi.openstack.custom.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.evoila.cf.cpi.openstack.custom.CustomIpAccessor;
import de.evoila.cf.cpi.openstack.custom.DefaultIpAccessor;
import de.evoila.cf.cpi.openstack.custom.IpAccessor;

/**
 * @author Christian Brinker, evoila.
 *
 */
@Configuration
public class OpenstackPlatformServiceConfig {

	@Value("${openstack.networkId}")
	private String networkId;

	@Value("${openstack.subnetId}")
	private String subnetId;

	@ConditionalOnMissingBean(CustomIpAccessor.class)
	@Bean
	public IpAccessor ipAccessor() {
		return new DefaultIpAccessor(networkId, subnetId);
	}
}
