/**
 * The MIT License
 *
 * Copyright (c) 2011 Daniel Ward dwa012(at)gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * No person, persons, or entity is allowed to sell or make any profit off this
 * software or variants of this software.
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * 
 * This class models a Devices with a name and address represented as a String
 * pair.
 *  
 * @author Daniel Ward
 * @version 1.00
 * @date Feb 16 2011
 */
public class  DevicePair<Name,Address> {

    private Name name;
    private Address address;
    
    public DevicePair(Name name, Address address){
        this.name = name;
        this.address  = address;
    }
    
    public Name getName()
    {
        return this.name;
    }
    
    public Address getAddress(){
        return this.address;
    }
}
