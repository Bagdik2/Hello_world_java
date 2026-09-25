/**
 * 
 */
/**
 * 
 */
module Hello_world {
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	exports hi;
	opens hi; //to com.fasterxml.jackson.databind;
	// Открывает пакет hi конкретно для модуля Jackson
//    opens hi to com.fasterxml.jackson.databind;
}