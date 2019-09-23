/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.datasketches.hive.quantiles;

import org.apache.datasketches.memory.Memory;
import org.apache.datasketches.quantiles.DoublesSketch;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.BytesWritable;

@Description(name = "ToString", value = "_FUNC_(sketch)",
extended = " Returns a human-readable summary of a given DoublesSketch.")
@SuppressWarnings("javadoc")
public class DoublesSketchToStringUDF extends UDF {

  /**
   * Returns a human-readable summary of a given sketch
   * @param serializedSketch serialized sketch
   * @return text summary
   */
  public String evaluate(final BytesWritable serializedSketch) {
    if (serializedSketch == null) { return null; }
    final DoublesSketch sketch = DoublesSketch.wrap(Memory.wrap(serializedSketch.getBytes()));
    return sketch.toString();
  }

}
