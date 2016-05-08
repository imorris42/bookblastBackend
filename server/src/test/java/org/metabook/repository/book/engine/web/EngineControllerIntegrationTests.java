package org.metabook.repository.book.engine.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.metabook.server.api.book.engine.web.EngineController;
import org.metabook.server.config.MetabookServerAppConfig;
import org.metabook.server.config.MetabookServerMvcConfig;
//import org.metabook.server.springboot.MetabookServerConfigContext;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkDiscoverer;
import org.springframework.hateoas.MediaTypes;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


/**
 * Integration tests for {@link EngineController}.
 * 
 * @author Ian Morris
 */
public class EngineControllerIntegrationTests extends org.metabook.server.AbstractWebIntegrationTest {

	private final String ENGINE_REL = MetabookServerMvcConfig.CURIE_NAMESPACE + ":" + EngineController.ENGINE_REL;

	@Test
	public void customControllerReturnsDefaultMediaType() throws Exception {

		MockHttpServletResponse response = mvc.perform(get("/")).//
				andDo(MockMvcResultHandlers.print()).//
				andExpect(linkWithRelIsPresent(ENGINE_REL)). //
				andReturn().getResponse();

		LinkDiscoverer discoverer = links.getLinkDiscovererFor(response.getContentType());
		Link link = discoverer.findLinkWithRel(ENGINE_REL, response.getContentAsString());

		mvc.perform(get(link.getHref())). //
				andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON));
	}
}
