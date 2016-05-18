package com.krieghb.javasnips.utilities;

public enum Enum_Numbers {

	ZERO				(0),
	
	ONE					(1),
	TWO					(2),
	THREE				(3),
	FOUR				(4),
	FIVE				(5),
	SIX					(6),
	SEVEN				(7),
	EIGHT				(8),
	NINE				(9),
	TEN					(10),
	
	ELEVEN				(11),
	TWELVE				(12),
	THIRTEEN			(13),
	FOURTEEN			(14),
	FIFTEEN				(15),
	SIXTEEN				(16),
	SEVENTEEN			(17),
	EIGHTEEN			(18),
	NINETEEN			(19),
	TWENTY				(20),
	
	TWENTYONE			(21),
	TWENTYTWO			(22),
	TWENTYTHREE			(23),
	TWENTYFOUR			(24),
	TWENTYFIVE			(25),
	TWENTYSIX			(26),
	TWENTYSEVEN			(27),
	TWENTYEIGHT			(28),
	TWENTYNINE			(29),
	THIRTY				(30),
	
	THIRTYONE			(31),
	THIRTYTWO			(32),
	THIRTYTHREE			(33),
	THIRTYFOUR			(34),
	THIRTYFIVE			(35),
	THIRTYSIX			(36),
	THIRTYSEVEN			(37),
	THIRTYEIGHT			(38),
	THIRTYNINE			(39),
	FOURTY				(40),
	
	FOURTYONE			(41),
	FOURTYTWO			(42),
	FOURTYTHREE			(43),
	FOURTYFOUR			(44),
	FOURTYFIVE			(45),
	FOURTYSIX			(46),
	FOURTYSEVEN			(47),
	FOURTYEIGHT			(48),
	FOURTYNINE			(49),
	FIFTY				(50)

	;
	
	
	private final int enumNum;
	
	private Enum_Numbers(int enumNum) {
		
		this.enumNum = enumNum;
	}
	
	public int value() {
		return this.enumNum;
	}

	public static char[] valueOf(int i) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
