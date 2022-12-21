package com.resource.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.resource.entity.Resource;

@Service
public class ResourceServiceImpl implements IResourceService {

	List<Resource> lis= List.of(
			new Resource(1L,"peter@gmail.com","peter","React Dev",1001L),
			new Resource(2L,"nishant@gmail.com","Nishant","Node Dev",1002L),
			new Resource(3L,"rishav@gmail.com","Rishav","Java Dev",1002L),
			new Resource(4L,"kumar@gmail.com","Kumar","React Dev",1003L),
			new Resource(5L,"parnava@gmail.com","Parnava","Python Dev",1004L),
			new Resource(6L,"shreya@gmail.com","Shreya","Java Dev",1004L),
			new Resource(7L,"ghosh@gmail.com","Ghosh","React Dev",1005L),
			new Resource(8L,"karan@gmail.com","Karan","Python Dev",1005L),
			new Resource(9L,"ratul@gmail.com","Ratul","Node Dev",1006L),
			new Resource(10L,"Rounak@gmail.com","Rounak","Vue Dev",1006L)
			);
	
	@Override
	public List<Resource> getResourceForUsers(Long userID) {
		// TODO Auto-generated method stub
		return lis.stream().filter(resource->resource.getUserID().equals(userID)).collect(Collectors.toList());
	}

}
