package mintic.edu.g33.e4.tgfront.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import mintic.edu.g33.e4.tgfront.model.Login;
import reactor.core.publisher.Mono;

@Service
public class IClientImp implements IClientStore {

	private static final String URL="http://localhost:8090";
		
	@Autowired
	private WebClient.Builder webClient;
	
	@Override
	public int login(Login login) {
		
		try {
			Mono<Integer> response=webClient.build().post().uri(URL + "/loginclient")
					.accept(MediaType.APPLICATION_JSON)
					.body(Mono.just(login), Login.class).retrieve()
					.bodyToMono(Integer.class);
			return response.block();
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->"+e.getMessage());
			return 0;
		}
		
	}
	
}
