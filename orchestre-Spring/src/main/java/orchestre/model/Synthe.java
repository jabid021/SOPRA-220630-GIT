package orchestre.model;

import org.springframework.stereotype.Component;

@Component
public class Synthe implements IInstrument{

	@Override
	public String son() {
		return "Le synthe fait slink slink";
	}

}
