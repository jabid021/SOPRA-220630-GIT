package orchestre.model;

import org.springframework.stereotype.Component;

@Component
public class Ukulele implements IInstrument{

	@Override
	public String son() {
		return "La ukulele fait ulink ulink";
	}

}
