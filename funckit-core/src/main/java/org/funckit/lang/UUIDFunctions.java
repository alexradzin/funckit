package org.funckit.lang;

import java.util.UUID;

import org.funckit.common.BaseAction;

public class UUIDFunctions {
	public static final BaseAction<String, UUID> fromString = new BaseAction<String, UUID>() {
		@Override
		public UUID execute(String name) {
			return UUID.fromString(name);
		}
	};
	
	public static final BaseAction<byte[], UUID> nameUUIDFromBytes = new BaseAction<byte[], UUID>() {
		@Override
		public UUID execute(byte[] name) {
			return UUID.nameUUIDFromBytes(name);
		}
	};
}
