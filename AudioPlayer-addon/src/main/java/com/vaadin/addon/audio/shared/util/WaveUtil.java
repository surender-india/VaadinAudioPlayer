package com.vaadin.addon.audio.shared.util;

import java.nio.ByteBuffer;

import com.vaadin.addon.audio.shared.PCMFormat;

/**
 * Utilities for working with WAVE files
 */
public final class WaveUtil {
	
	/**
	 * Read a little endian value (up to 4 bytes) from a ByteBuffer
	 * 
	 * @param buffer buffer to read from
	 * @param offset byte offset to start reading from
	 * @param bytes number of bytes to read
	 * @return the bytes read interpreted as an integer value
	 */
	public static int readLE(ByteBuffer buffer, int offset, int bytes) {
		assert(bytes > 0 && bytes < 5);
		
		int value = 0;
		int shift = 0;
		for(int b = 0; b < bytes; ++b) {
			value |= (buffer.get(offset + b) & 0xff) << shift;
			shift += 8;
		}
		
		return value;
	}
	
	/**
	 * Write an integer as a little endian value (up to 4 bytes) into a bytebuffer
	 * 
	 * @param value value to write
	 * @param buffer buffer to write to
	 * @param offset byte offset to start writing at
	 * @param bytes number of bytes to write
	 */
	public static void writeLE(int value, ByteBuffer buffer, int offset, int bytes) {
		assert(bytes > 0 && bytes < 5);
		
		int shift = 0;
		for(int b = 0; b < bytes; ++b) {
			buffer.put(offset + b, (byte)((value >>> shift) & 0xff));
			shift += 8;
		}
	}

	/**
	 * Read a big endian value (up to 4 bytes) from a ByteBuffer
	 * 
	 * @param buffer buffer to read from
	 * @param offset byte offset to start reading from
	 * @param bytes number of bytes to read
	 * @return the bytes read interpreted as an integer value
	 */
	public static int readBE(ByteBuffer buffer, int offset, int bytes) {
		assert(bytes > 0 && bytes < 5);
		
		int value = 0;
		int shift = (bytes - 1) * 8;
		for(int b = 0; b < bytes; ++b) {
			value |= (buffer.get(offset + b) & 0xff) << shift;
			shift -= 8;
		}
		
		return value;
	}
	
	/**
	 * Write an integer as a big endian value (up to 4 bytes) into a bytebuffer
	 * 
	 * @param value value to write
	 * @param buffer buffer to write to
	 * @param offset byte offset to start writing at
	 * @param bytes number of bytes to write
	 */
	public static void writeBE(int value, ByteBuffer buffer, int offset, int bytes) {
		assert(bytes > 0 && bytes < 5);

		int shift = (bytes - 1) * 8;
		for(int b = 0; b < bytes; ++b) {
			buffer.put(offset + b, (byte)((value >>> shift) & 0xff));
			shift -= 8;
		}
	}
	
	/**
	 * Read Wave header to get data format 
	 * 
	 * @param waveFileBytes bytebuffer containing data of wave file
	 * @return a PCMFormat object 
	 */
	public static PCMFormat getDataFormat(ByteBuffer waveFileBytes) {
		PCMFormat fmt = null;
		
		return fmt;
	}
	
	public static int getDataStartOffset(ByteBuffer waveFileBytes) {
		
		
		return 0;
	}
	
	public static int getDataLength(ByteBuffer waveFileBytes) {
		
		
		return 0;
	}
	
	public static byte[] generateHeader(PCMFormat format, int dataLength) {
		byte[] header = new byte[44];	// MS Wave header is exactly 44 bytes long
		ByteBuffer buf = ByteBuffer.wrap(header);
		
		
		
		return header;
	}
	
}