/*
  Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.x.io;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.mysql.cj.api.result.RowList;
import com.mysql.cj.core.result.Field;

/**
 * @todo doc
 */
public class XProtocolRowInputStream implements RowList {
    private ArrayList<Field> metadata;
    private XProtocol protocol;
    private boolean isDone = false;
    private int position = -1;
    /** @todo doc */
    private XProtocolRow next;

    public XProtocolRowInputStream(ArrayList<Field> metadata, XProtocol protocol) {
        this.metadata = metadata;
        this.protocol = protocol;
    }

    public XProtocolRow readRow() {
        if (!hasNext()) {
            this.isDone = true;
            return null;
        }
        this.position++;
        XProtocolRow r = this.next;
        this.next = null;
        return r;
    }

    public XProtocolRow next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return readRow();
    }

    public boolean hasNext() {
        if (this.isDone) {
            return false;
        } else if (this.next == null) {
            this.next = this.protocol.readRowOrNull(this.metadata);
        }
        return this.next != null;
    }

    public int getPosition() {
        return this.position;
    }
}
