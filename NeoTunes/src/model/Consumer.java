package model;

import java.time.LocalDate;

public abstract class Consumer extends User implements AddedSongs{

	public Consumer(String nickName, String id, LocalDate dates) {
		super(nickName, id, dates);
		
	}

}
