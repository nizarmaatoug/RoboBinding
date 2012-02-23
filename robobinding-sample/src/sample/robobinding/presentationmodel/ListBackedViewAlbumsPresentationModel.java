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
package sample.robobinding.presentationmodel;

import java.util.List;

import org.robobinding.presentationmodel.DependsOnStateOf;
import org.robobinding.presentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.PresentationModel;

import sample.robobinding.model.Album;
import sample.robobinding.store.AlbumStore;
import android.app.Activity;

import com.google.common.collect.Lists;

/**
 * 
 * @since 1.0
 * @author Cheng Wei
 * @author Robert Taylor
 */
@PresentationModel
public class ListBackedViewAlbumsPresentationModel extends AbstractViewAlbumsPresentationModel
{
	public ListBackedViewAlbumsPresentationModel(Activity activity)
	{
		super(activity);
	}
	
	@ItemPresentationModel(AlbumItemPresentationModel.class)
	public List<Album> getAlbums()
	{
		return Lists.newArrayList(AlbumStore.getAll());
	}
	
	@DependsOnStateOf("selectedAlbumPosition")
	public boolean isViewAlbumFieldsEnabled()
	{
	    return selectedAlbumPosition >= 0;
	}
}