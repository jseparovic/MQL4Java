/**
 Copyright 2016 Jason Separovic

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.jseppa.mql4java.base.mql;

public class RateInfo
{
    public long time;      // open date and time
    public double open;     // Open price (absolute value)
    public double high;     // Low price
    public double low;      // High price
    public double close;    // Close price
    public long volume;   // tick volume
    public int spread;    // spread
    public long real;     // trade volume

    public RateInfo(long time, double open, double high, double low, double close, long volume, int spread, long real)
    {
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.spread = spread;
        this.real = real;
    }
}
