// Contains an array of current key state
// previous key state. A value of true
// means the key is pressed.

// The GamePanel KeyListener will update the array.
// All GameStates now have a handleInput() function
// in order to keep all keyboard input operations
// on the game thread rather than on the EDT to avoid
// problems.

package com.neet.DiamondHunter.Manager;

import java.awt.event.KeyEvent;

public class Keys {
	
	public static final int NUM_KEYS = 8;
	
	public static boolean keyState[] = new boolean[NUM_KEYS];
	public static boolean prevKeyState[] = new boolean[NUM_KEYS];
	
	public static int keys[] = {KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE,
			KeyEvent.VK_ENTER, KeyEvent.VK_ESCAPE, KeyEvent.VK_F1};
	
	public static int keySet(int i, boolean b) {
		for (int j = 0; j<keys.length; j++){
			if(i == keys[j]){
				keyState[j] = b;
			}
		}
		return 0;
	}
	
	public static int update() {
		for(int i = 0; i < NUM_KEYS; i++) {
			prevKeyState[i] = keyState[i];
		}
		return 0;
	}
	
	public static boolean isPressed(int i) {
		return keyState[i] && !prevKeyState[i];
	}
	
	public static boolean isDown(int i) {
		return keyState[i];
	}
	
	public static boolean anyKeyDown() {
		for(int i = 0; i < NUM_KEYS; i++) {
			if(keyState[i]) return true;
		}
		return false;
	}
	
	public static boolean anyKeyPress() {
		for(int i = 0; i < NUM_KEYS; i++) {
			if(keyState[i] && !prevKeyState[i]) return true;
		}
		return false;
	}
	
}
