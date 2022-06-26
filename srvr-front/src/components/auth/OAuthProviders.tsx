import styled from "styled-components";

type ElementProps = {
  src: string;
  alt?: string;
  onClick?: React.MouseEventHandler<HTMLImageElement>;
};

type Props = {};

export default function OAuthProviders({}: Props): JSX.Element {
  const oauthProviderElements: Array<ElementProps> = [
    {
      src: "",
    },
    {
      src: "",
    },
    {
      src: "",
    },
    {
      src: "",
    },
  ];

  return (
    <OAuthProvidersWrapper>
      {oauthProviderElements.map((e, index) => (
        <OAuthProviderElement src={e.src} key={index} />
      ))}
    </OAuthProvidersWrapper>
  );
}

const OAuthProvidersWrapper = styled.div`
  margin-top: 77px;
  margin-bottom: 61px;
  & > .oauth_provier_element_wrapper::after {
    content: "";
    position: relative;
    height: 10px;
    border-right: 1px solid ${({ theme }) => theme.color.secondray};

    left: 54px;
  }

  & > .oauth_provier_element_wrapper:last-child::after {
    border-right: none;
  }
`;

function OAuthProviderElement({
  src,
  alt,
  onClick,
}: ElementProps): JSX.Element {
  return (
    <OAuthProviderElementWrapper className="oauth_provier_element_wrapper">
      <img src={src} alt={alt} onClick={onClick} />
    </OAuthProviderElementWrapper>
  );
}

const OAuthProviderElementWrapper = styled.button`
  width: 60px;
  height: 60px;
  margin: 0 24px;
  border-radius: 30px;

  background-color: ${({ theme }) => theme.color.grey};

  transition: 0.3s;

  &:hover {
    opacity: 0.7;
  }
`;
