/**
 * Copyright 2011 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute.view;

import org.robobinding.viewattribute.AbstractCommandViewAttribute;
import org.robobinding.viewattribute.Command;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 */
public class OnClickAttribute extends AbstractCommandViewAttribute
{
	final View view;

	public OnClickAttribute(View view, String commandName)
	{
		super(commandName);
		this.view = view;
	}

	@Override
	protected void bind(final Command command)
	{
		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				ClickEvent clickEvent = new ClickEvent(v);
				command.invoke(clickEvent);
			}
		});
	}

	@Override
	protected Class<?> getPreferredCommandParameterType()
	{
		return ClickEvent.class;
	}
}