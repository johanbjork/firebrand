/*
 * Copyright (C) 2012 47 Degrees, LLC
 * http://47deg.com
 * hello@47deg.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.firebrandocm.tests;

import org.apache.cassandra.db.marshal.CounterColumnType;
import org.firebrandocm.dao.annotations.*;

@ColumnFamily(defaultValidationClass = CounterColumnType.class)
public class FirstEntityCounter {

	@Key
	private String id;
	
	@Column(counter = true, validationClass = CounterColumnType.class)
	private long counterProperty;

	@CounterIncrease("counterProperty")
	private long counterPropertyIncreaseBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCounterProperty() {
		return counterProperty;
	}

	public void setCounterProperty(long counterProperty) {
		this.counterProperty = counterProperty;
	}

	public long getCounterPropertyIncreaseBy() {
		return counterPropertyIncreaseBy;
	}

	public void setCounterPropertyIncreaseBy(long counterPropertyIncreaseBy) {
		this.counterPropertyIncreaseBy = counterPropertyIncreaseBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FirstEntityCounter)) return false;

		FirstEntityCounter that = (FirstEntityCounter) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "FirstEntityCounter{" +
				"id='" + id + '\'' +
				'}';
	}
}

