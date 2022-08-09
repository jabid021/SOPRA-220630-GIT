package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pianiste implements IMusicien{
	
	@Autowired
	private Synthe instrument;
	
	public Pianiste() {
		//System.out.println("Le pianiste equipe son "+instrument.getClass().getSimpleName());
	}
	
	public Synthe getInstrument() {
		return instrument;
	}



	public void setInstrument(Synthe instrument) {
		this.instrument = instrument;
	}



	@Override
	public void jouer() {
		System.out.println("Le pianiste joue ! "+instrument.son());
		
	}

}
